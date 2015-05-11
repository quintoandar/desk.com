package br.com.quintoandar.desk.com.common;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class DeskObj implements Serializable {
	public static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String DATE_TIMEZONE = "GMT";
	private static final long serialVersionUID = -4862002378394837110L;
	
	BigInteger id;

	@JsonProperty("created_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date createdAt = new Date();
	
	@JsonProperty("updated_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date updatedAt = new Date();
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date created_at) {
		this.createdAt = created_at;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updated_at) {
		this.updatedAt = updated_at;
	}
	
	public void addToLinks(Map<String, DeskLink> links, String as){
		links.put(as, DeskLink.create(this, null));
	}
	public void addToLinks(Map<String, DeskLink> links, String as, String klass){
		links.put(as, DeskLink.create(this, klass));
	}
	
}
