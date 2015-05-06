package br.com.quintoandar.desk.com.common;

import java.util.List;
/**
 * 
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 * @param <T>
 */
public class SearchResponse<T> {

	Integer page;
	
	Integer total_entries;
	
	String next;
	
	String previous;
	
	EntriesEmbedded<T> _embedded;
	
	public static class EntriesEmbedded<S> {
		List<S> entries;
	}
}
