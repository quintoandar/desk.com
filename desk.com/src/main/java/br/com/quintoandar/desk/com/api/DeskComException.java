package br.com.quintoandar.desk.com.api;

import org.jboss.resteasy.client.ClientResponseFailure;

public class DeskComException extends Exception {
	private static final long serialVersionUID = 1193422764180340694L;
	private Integer statusCode;

	public DeskComException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeskComException(String message) {
		super(message);
	}

	public DeskComException(ClientResponseFailure t) {
		super(String.format("Http Status %d: %s", t.getResponse().getStatus(), t.getResponse().getEntity(String.class)), t);
		this.statusCode = t.getResponse().getStatus();
	}

	public Integer getStatusCode() {
		return statusCode;
	}
}
