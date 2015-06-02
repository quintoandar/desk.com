package br.com.quintoandar.desk.com.company;

import java.util.Set;
import java.math.BigInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.quintoandar.desk.com.cases.Case;
import br.com.quintoandar.desk.com.common.OAuthHelper;
import br.com.quintoandar.desk.com.common.SearchResponse;

@Path("/api/v2")
public interface CompanyApi {

	/**
	 * @see http://dev.desk.com/API/companies/#list
	 * @param page
	 * @return
	 */
	@GET
	@Path("/companies")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchResponse<Company> list(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @QueryParam("page") Integer page);


	/**
	 * @see http://dev.desk.com/API/companies/#show
	 * @param companyId
	 * @return
	 */
	@GET
	@Path("/companies/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Company search(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @PathParam("id") BigInteger companyId);

	/**
	 * @see http://dev.desk.com/API/companies/#cases-list
	 * @param companyId
	 * @param page
	 * @return
	 */
	@GET
	@Path("/companies/{company_id}/cases")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchResponse<Case> listCases(
		@HeaderParam(OAuthHelper.PARAM_NAME) String auth,
		@PathParam("company_id") BigInteger companyId,
		@QueryParam("page") Integer page
	);
}
