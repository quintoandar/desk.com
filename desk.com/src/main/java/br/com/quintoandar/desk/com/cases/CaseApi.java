package br.com.quintoandar.desk.com.cases;

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

import br.com.quintoandar.desk.com.common.OAuthHelper;

@Path("/api/v2")
public interface CaseApi<T extends Case> {

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
	public SearchCaseResponse<T> casesFromCustomer(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @PathParam("id") String customerId, @QueryParam("sort_field") @DefaultValue("created_at") String sortField, @QueryParam("sort_direction") @DefaultValue("asc") String sortDir);

	/**
	 * @see http://dev.desk.com/API/customers/#cases
	 * @param customerId
	 * @return
	 */
	@GET
	@Path("/cases")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchCaseResponse<T> cases(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @QueryParam("customer_id") String customerId, @QueryParam("company_id") String companyId);
	

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
	public T createCase(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @PathParam("id") String customerId, T newCase);

}
