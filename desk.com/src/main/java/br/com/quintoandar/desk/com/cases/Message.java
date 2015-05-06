package br.com.quintoandar.desk.com.cases;

import br.com.quintoandar.desk.com.common.DeskObj;

/**
 * @see http://dev.desk.com/API/cases/#message-fields
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 * 
 */
public class Message extends DeskObj {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5748769668147279174L;
	MessageDirection direction;
	MessageStatus status;
	String body;
	String from;
	String to;
	String cc;
	String bcc;
	String client_type;

	public MessageDirection getDirection() {
		return direction;
	}

	public void setDirection(MessageDirection direction) {
		this.direction = direction;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getClient_type() {
		return client_type;
	}

	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
}
