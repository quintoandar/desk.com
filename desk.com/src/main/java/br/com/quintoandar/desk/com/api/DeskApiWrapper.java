package br.com.quintoandar.desk.com.api;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import br.com.quintoandar.desk.com.cases.Case;
import br.com.quintoandar.desk.com.cases.CaseApi;
import br.com.quintoandar.desk.com.cases.Message;
import br.com.quintoandar.desk.com.common.OAuthHelper;
import br.com.quintoandar.desk.com.customer.Customer;
import br.com.quintoandar.desk.com.customer.CustomerApi;
import br.com.quintoandar.desk.com.users.User;
import br.com.quintoandar.desk.com.users.UserApi;

/**
 * Wrapper para centralizar ações via api do DeksCom
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 */
public class DeskApiWrapper {

	private static final String DESK_COM_DEFAULT_ENDPOINT = "http://quin.to/";
	private String accessKey;
	private String accessSecret;
	private String token;
	private String tokenSecret;
	private OAuthHelper oauthHelper;
	private String endpoint;
	private UserApi<User> userApi;
	private CustomerApi<Customer> customerApi;
	private CaseApi caseApi;

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

	public void init() {
		if (oauthHelper == null) {
			oauthHelper = new OAuthHelper(accessKey, accessSecret, token, tokenSecret);
		}

		ClientConnectionManager cm = new ThreadSafeClientConnManager();
		DefaultHttpClient httpClient = new DefaultHttpClient(cm);

		ClientExecutor executor = new ApacheHttpClient4Executor(httpClient);

		
		userApi = ProxyFactory.create(UserApi.class, endpoint, executor);
		customerApi = ProxyFactory.create(CustomerApi.class, endpoint, executor);
		caseApi = ProxyFactory.create(CaseApi.class, endpoint, executor);
	}
	
	public List<Customer> searchCustomer(Set<String> email, Set<String> externalId){
		return customerApi.search(oauthHelper.genAuthorizationHeader(), null, null, email, externalId).get_embedded().getEntries();
	}

	public Customer showCustomer(BigInteger id){
		return customerApi.show(oauthHelper.genAuthorizationHeader(), id.toString());
	}
	
	public Customer newCustomer(Customer customer){
		return customerApi.create(oauthHelper.genAuthorizationHeader(), customer);
	}

	public Case newCase(Customer customer, Case newCase) {
		return caseApi.createCase(oauthHelper.genAuthorizationHeader(), customer.getId(), newCase);
	}

	public List<User> searchUser(Set<String> emails) {
		Set<User> usuarios = new LinkedHashSet<User>();
		for(User us: userApi.users(oauthHelper.genAuthorizationHeader(), null, null).get_embedded().getEntries()) {
			if(emails.contains(us.getEmail())){
				usuarios.add(us);
			}
		}
		return new LinkedList(usuarios);
	}

	public Message newMessage(BigInteger id, Message msg) {
		return caseApi.createReplyCase(oauthHelper.genAuthorizationHeader(), id, msg);
	}

}
