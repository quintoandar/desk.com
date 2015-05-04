package br.com.quintoandar.desk.com.common;

import java.io.Serializable;
/**
 * 
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 */
public class DeskContact implements Serializable {
	private static final long serialVersionUID = 6044171298040301569L;
	ContactType type;
	String value;

	public DeskContact(ContactType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	public ContactType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}
}
