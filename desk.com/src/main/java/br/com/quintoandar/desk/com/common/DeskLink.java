package br.com.quintoandar.desk.com.common;

import br.com.quintoandar.desk.com.customer.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeskLink {

	private String href;
	
	@JsonProperty("class")
	private String klass;
	
//	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonIgnore
	private Integer count;
	
	public DeskLink() {
		this(null,null);
	}
	
	public DeskLink(String klass, String href) {
		this.href = href;
		this.klass = klass;
	}
	
	public static DeskLink create(DeskObj c, String klass){
		String apiName = c.getClass().getSimpleName().toLowerCase().replaceAll("([^s])$", "$1s");
		DeskLink dl = new DeskLink(klass != null?klass:apiName, String.format("/api/v2/%s/%d",apiName,c.getId()));
		return dl;
	}

	public static DeskLink create(Customer c){
		return create(c, "customer");
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
