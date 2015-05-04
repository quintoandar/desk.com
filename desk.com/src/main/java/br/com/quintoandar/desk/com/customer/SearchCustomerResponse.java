package br.com.quintoandar.desk.com.customer;

import java.util.List;
/**
 * 
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 * @param <T>
 */
public class SearchCustomerResponse<T extends Customer> {

	Integer page;
	
	Integer total_entries;
	
	String next;
	
	String previous;
	
	EntriesEmbedded<T> _embedded;
	
	public static class EntriesEmbedded<S extends Customer> {
		List<S> entries;
	}
}
