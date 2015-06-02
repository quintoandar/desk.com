package br.com.quintoandar.desk.com.api;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientResponseFailure;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import br.com.quintoandar.desk.com.cases.Case;
import br.com.quintoandar.desk.com.cases.CaseApi;
import br.com.quintoandar.desk.com.cases.Message;
import br.com.quintoandar.desk.com.common.OAuthHelper;
import br.com.quintoandar.desk.com.customer.Customer;
import br.com.quintoandar.desk.com.customer.CustomerApi;
import br.com.quintoandar.desk.com.customer.SearchCustomerResponse;
import br.com.quintoandar.desk.com.users.User;
import br.com.quintoandar.desk.com.users.UserApi;
import br.com.quintoandar.desk.com.company.Company;
import br.com.quintoandar.desk.com.company.CompanyApi;
import br.com.quintoandar.desk.com.common.SearchResponse;

/**
 * Wrapper para centralizar ações via api do DeksCom
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 */
public class DeskApiWrapper {

	private static final String DESK_COM_DEFAULT_ENDPOINT = "https://desk.com";
	private String accessKey;
	private String accessSecret;
	private String token;
	private String tokenSecret;
	private OAuthHelper oauthHelper;
	private String endpoint;
	private UserApi userApi;
	private CustomerApi customerApi;
	private CaseApi caseApi;
	private CompanyApi companyApi;
	private String authorizationHeader;

	public DeskApiWrapper() {
		this(DESK_COM_DEFAULT_ENDPOINT);
	}

	public DeskApiWrapper(String endpoint) {
		super();
		this.endpoint = endpoint;
	}

	public void setAccess(String key, String secret) {
		this.accessKey = key;
		this.accessSecret = secret;
	}

	public void setToken(String token, String secret) {
		this.token = token;
		this.tokenSecret = secret;
	}

	public void setBasicAuth(String user, String password) throws IOException {
		String token = user + ":" + password;
		authorizationHeader = "Basic " + Base64.encodeBase64String(token.getBytes("UTF-8"));
	}

	public void init() {
		if (authorizationHeader == null) {
			oauthHelper = new OAuthHelper(accessKey, accessSecret, token, tokenSecret);
			authorizationHeader = oauthHelper.genAuthorizationHeader();
		}

		ClientConnectionManager cm = new ThreadSafeClientConnManager();
		DefaultHttpClient httpClient = new DefaultHttpClient(cm);

		ClientExecutor executor = new ApacheHttpClient4Executor(httpClient);


		userApi = ProxyFactory.create(UserApi.class, endpoint, executor);
		customerApi = ProxyFactory.create(CustomerApi.class, endpoint, executor);
		caseApi = ProxyFactory.create(CaseApi.class, endpoint, executor);
	}

	/**
	 * Returns if this wrapper is ready to be used. A.k.a. init() was called.
	 * @return
	 */
	public boolean isReady(){
		return oauthHelper != null;
	}

	public List<Customer> searchCustomer(Set<String> email, Set<String> externalId) throws DeskComException{
		try {
			SearchCustomerResponse<Customer> customer = customerApi.search(authorizationHeader, null, null, email, externalId);
			return customer.get_embedded().getEntries();
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	public Customer showCustomer(BigInteger id) throws DeskComException{
		try{
			return customerApi.show(authorizationHeader, id.toString());
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	public Customer newCustomer(Customer customer) throws DeskComException{
		try{
			return customerApi.create(authorizationHeader, customer);
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	public Case newCase(Customer customer, Case newCase) throws DeskComException {
		try {
			return caseApi.createCase(authorizationHeader, customer.getId(), newCase);
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	/**
	 * if caseId is present, case id. Other wise tries caseExternalId
	 * @param caseId
	 * @param caseExternalId
	 * @param embeds (optional)
	 * @return
	 * @throws DeskComException
	 */
	public Case showCase(BigInteger caseId, String caseExternalId, Set<String> embeds) throws DeskComException {
		try {
			if(caseId != null){
				return caseApi.showCase(authorizationHeader, caseId,embeds);
			} else {
				return caseApi.showCase(authorizationHeader, caseExternalId, embeds);
			}
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	public List<User> searchUser(Set<String> emails) throws DeskComException {
		Set<User> usuarios = new LinkedHashSet<User>();
		try{
			for(User us: userApi.users(authorizationHeader, null, null).get_embedded().getEntries()) {
				if(emails.contains(us.getEmail())){
					usuarios.add(us);
				}
			}
			return new LinkedList(usuarios);
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	public Message newMessage(BigInteger id, Message msg) throws DeskComException {
		try {
			return caseApi.createReplyCase(authorizationHeader, id, msg);
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	public List<Case> listCases(Customer customer) throws DeskComException {
		return listCases(customer.getId());
	}

	public List<Case> listCases(BigInteger customerId) throws DeskComException {
		Set<Case> cases = new LinkedHashSet<Case>();
		try {
			for(Case kase:caseApi.casesFromCustomer(authorizationHeader, customerId,null,null).get_embedded().getEntries()){
				cases.add(kase);
			}
			return new LinkedList<Case>(cases);
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	public List<Company> listAllCompanies() throws DeskComException {
		Set<Company> companies = new LinkedHashSet<Company>();
		try {
			Integer page = 1;
			SearchResponse<Company> results;
			do {
				results = companyApi.list(authorizationHeader, page++);
				for(Company company: results.get_embedded().getEntries()) {
					companies.add(company);
				}
			} while (results.hasNextPage());
			return new LinkedList<Company>(companies);
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}

	public List<Case> listAllCompanyCases(Company company) throws DeskComException {
		return listAllCompanyCases(company.getId());
	}

	public List<Case> listAllCompanyCases(BigInteger companyId) throws DeskComException {
		Set<Case> cases = new LinkedHashSet<Case>();
		try {
			Integer page = 1;
			SearchResponse<Case> results;
			do {
				results = companyApi.listCases(authorizationHeader, companyId, page++);
				for(Case _case : results.get_embedded().getEntries()) {
					cases.add(_case);
				}
			} while (results.hasNextPage());
			return new LinkedList<Case>(cases);
		}catch(ClientResponseFailure t){
			throw new DeskComException(t);
		}
	}
}
