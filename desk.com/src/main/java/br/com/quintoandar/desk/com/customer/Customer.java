package br.com.quintoandar.desk.com.customer;

import java.util.LinkedList;
import java.util.List;

import br.com.quintoandar.desk.com.common.DeskContact;
import br.com.quintoandar.desk.com.common.DeskObj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer extends DeskObj {
	private static final long serialVersionUID = -7246651944741909896L;
	
	@JsonProperty("first_name")
	String firstName;
	
	@JsonProperty("last_name")
	String lastName;
	
	String company;
	
	String title;
	
	String external_id;

	List<DeskContact> emails = new LinkedList<DeskContact>();
	List<DeskContact> phone_numbers = new LinkedList<DeskContact>();
	List<DeskContact> adresses = new LinkedList<DeskContact>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExternal_id() {
		return external_id;
	}

	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	public List<DeskContact> getEmails() {
		return emails;
	}

	public void setEmails(List<DeskContact> emails) {
		this.emails = emails;
	}

	public List<DeskContact> getPhone_numbers() {
		return phone_numbers;
	}

	public void setPhone_numbers(List<DeskContact> phone_numbers) {
		this.phone_numbers = phone_numbers;
	}

	public List<DeskContact> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<DeskContact> adresses) {
		this.adresses = adresses;
	}
}
