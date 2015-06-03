package br.com.quintoandar.desk.com.cases;

import java.math.BigInteger;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.quintoandar.desk.com.common.auth.DeskOAuthProvider;

@Path("/api/v2")
public interface CaseApi {

	/**
	 * @see http://dev.desk.com/API/customers/#cases
	 * @param customerId
	 * @param sortField possible values: id, created_at, priority, received_at, status, and updated_at. Defaults to 'created_at' 
	 * @param sortDir direction of sorting (asc|desc). Defaults to 'asc'
	 * @return
	 */
	@GET
	@Path("/customers/{id}/cases")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchCaseResponse<Case> casesFromCustomer(@HeaderParam(DeskOAuthProvider.PARAM_NAME) String auth, @PathParam("id") BigInteger customerId, @QueryParam("sort_field") @DefaultValue("created_at") String sortField, @QueryParam("sort_direction") @DefaultValue("asc") String sortDir);

	/**
	 * @see http://dev.desk.com/API/customers/#cases
	 * @param customerId
	 * @return
	 */
	@GET
	@Path("/cases")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchCaseResponse<Case> cases(@HeaderParam(DeskOAuthProvider.PARAM_NAME) String auth, @QueryParam("customer_id") String customerId, @QueryParam("company_id") String companyId);


	/**
	 * @see http://dev.desk.com/API/cases/#create
	 * @param customerId
	 * @param newcase
	 * @return
	 */
	@POST
	@Path("/customers/{id}/cases")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Case createCase(@HeaderParam(DeskOAuthProvider.PARAM_NAME) String auth, @PathParam("id") BigInteger customerId, Case newCase);
	
	/**
	 * @see http://dev.desk.com/API/cases/#show
	 * @param caseId
	 * @param embed embed elements to be retrieved
	 * @return
	 */
	@GET
	@Path("/cases/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Case showCase(@HeaderParam(DeskOAuthProvider.PARAM_NAME) String auth, @PathParam("id") BigInteger caseId, @QueryParam("embed") Set<String> embed);

	/**
	 * @see http://dev.desk.com/API/cases/#show
	 * @param externalId
	 * @param embed embed elements to be retrieved
	 * @return
	 */
	@GET
	@Path("/cases/e-{externalId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Case showCase(@HeaderParam(DeskOAuthProvider.PARAM_NAME) String auth, @PathParam("externalId") String externalId, @QueryParam("embed") Set<String> embed);
	
	/**
	 * @see http://dev.desk.com/API/cases/#replies-create
	 * @param customerId
	 * @param newcase
	 * @return
	 */
	@POST
	@Path("/cases/{id}/reply")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message createReplyCase(@HeaderParam(DeskOAuthProvider.PARAM_NAME) String auth, @PathParam("id") BigInteger caseId, Message message);

}
