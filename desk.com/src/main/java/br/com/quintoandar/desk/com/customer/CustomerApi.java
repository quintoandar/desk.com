package br.com.quintoandar.desk.com.customer;

import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/api/v2")
public interface CustomerApi<T extends Customer> {

	public SearchCustomerResponse<T> search(@QueryParam("first_name") String firstName, @QueryParam("last_name") String lastName, @QueryParam("email") Set<String> emails, @QueryParam("external_id") Set<String> externalIds);
}
