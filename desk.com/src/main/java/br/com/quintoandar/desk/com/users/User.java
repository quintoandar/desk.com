package br.com.quintoandar.desk.com.users;

import java.util.Date;

import br.com.quintoandar.desk.com.common.DeskObj;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @see http://dev.desk.com/API/users/#fields
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends DeskObj {
	private static final long serialVersionUID = 3667092836804035933L;
	String name;
	String public_name;
	String email;
	Boolean email_verified;
	String level;

	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date current_login_at;

	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date last_login_at;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublic_name() {
		return public_name;
	}

	public void setPublic_name(String public_name) {
		this.public_name = public_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmail_verified() {
		return email_verified;
	}

	public void setEmail_verified(Boolean email_verified) {
		this.email_verified = email_verified;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getCurrent_login_at() {
		return current_login_at;
	}

	public void setCurrent_login_at(Date current_login_at) {
		this.current_login_at = current_login_at;
	}

	public Date getLast_login_at() {
		return last_login_at;
	}

	public void setLast_login_at(Date last_login_at) {
		this.last_login_at = last_login_at;
	}
}
