package br.com.quintoandar.desk.com.customer;

import java.math.BigInteger;
import java.util.List;

import br.com.quintoandar.desk.com.common.DeskContact;

/**
 * 
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 */
public class Customer {
	BigInteger id;
	String firstName;
	String lastName;
	String company;
	String external_id;

	List<DeskContact> emails;
	List<DeskContact> phone_numbers;
	List<DeskContact> adresses;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
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
