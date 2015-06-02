package br.com.quintoandar.desk.com.company;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.com.quintoandar.desk.com.common.DeskContact;
import br.com.quintoandar.desk.com.common.DeskObj;
import br.com.quintoandar.desk.com.common.DeskLink;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company extends DeskObj {
	private static final long serialVersionUID = -7246651944741909896L;

	@JsonProperty("external_id")
	String externalId;

	@JsonProperty("name")
	String name;

	@JsonProperty("created_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date createdAt;

	@JsonProperty("updated_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date updatedAt;

	List<String> domains = new LinkedList<String>();

	@JsonProperty("_links")
	Map<String, DeskLink> links = new TreeMap<String, DeskLink>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<String> getDomains() {
		return domains;
	}

	public void setDomains(List<String> domains) {
		this.domains = domains;
	}


	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

}
