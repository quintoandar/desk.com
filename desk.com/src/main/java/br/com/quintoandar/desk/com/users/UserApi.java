package br.com.quintoandar.desk.com.users;

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
public interface UserApi<T extends User> {

	/**
	 * @see http://dev.desk.com/API/users/#list
	 * @param sortField possible values: id, name. Defaults to 'id' 
	 * @param sortDir direction of sorting (asc|desc). Defaults to 'asc'
	 * @return
	 */
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchUserResponse<T> users(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @QueryParam("sort_field") @DefaultValue("id") String sortField, @QueryParam("sort_direction") @DefaultValue("asc") String sortDir);

	/**
	 * @see http://dev.desk.com/API/users/#show
	 * @param userId
	 * @return
	 */
	@POST
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public T show(@HeaderParam(OAuthHelper.PARAM_NAME) String auth, @PathParam("id") String userId);

}
