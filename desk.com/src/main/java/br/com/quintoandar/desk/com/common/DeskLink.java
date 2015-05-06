package br.com.quintoandar.desk.com.common;

import br.com.quintoandar.desk.com.customer.Customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeskLink {

	private String href;
	
	@JsonProperty("class")
	private String klass;
	
	public static DeskLink create(Customer c){
		DeskLink dl = new DeskLink();
		dl.setHref(String.format("/apiv/v2/customer/%d",c.getId()));
		dl.setKlass("customer");
		return dl;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getKlass() {
		return klass;
	}

	public void setKlass(String klass) {
		this.klass = klass;
	}
}
