package br.com.quintoandar.desk.com.customer;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.quintoandar.desk.com.common.OAuthHelper;

@Path("/api/v2")
public interface CustomerApi<T extends Customer> {

	/**
	 * @see http://dev.desk.com/API/customers/#search
	 * @param firstName
	 * @param lastName
	 * @param emails
	 * @param externalIds
	 * @return
	 */
	@GET
	@Path("/customers/search")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchCustomerResponse<T> search(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @QueryParam("first_name") String firstName, @QueryParam("last_name") String lastName, @QueryParam("email") Set<String> emails, @QueryParam("external_id") Set<String> externalIds);

	/**
	 * @see http://dev.desk.com/API/customers/#show
	 * @param customerId
	 * @return
	 */
	@GET
	@Path("/customers/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public <T extends Customer> T show(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @PathParam("id") String customerId);
	
	/**
	 * @see http://dev.desk.com/API/customers/#show
	 * @param customerId
	 * @return
	 */
	@POST
	@Path("/customers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public <T extends Customer> T create(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, Customer customer);
}
