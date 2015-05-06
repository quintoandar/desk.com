package br.com.quintoandar.desk.com.common;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class DeskObj implements Serializable {
	public static final String DATE_PATTERN = "";
	public static final String DATE_TIMEZONE = "";
	private static final long serialVersionUID = -4862002378394837110L;
	
	BigInteger id;

	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date created_at;

	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date updated_at;
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}
