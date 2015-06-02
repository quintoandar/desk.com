package br.com.quintoandar.desk.com.common;

import br.com.quintoandar.desk.com.customer.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.math.NumberUtils;
import java.math.BigInteger;

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
		String klassNameSing = c.getClass().getSimpleName().toLowerCase();
		String klassNamePlural = klassNameSing.replaceAll("([^s])$", "$1s");
		DeskLink dl = new DeskLink(klass != null?klass:klassNameSing, String.format("/api/v2/%s/%d",klassNamePlural,c.getId()));
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

	public BigInteger getObjectId() {
		if (this.href != null && this.href.length() > 0) {
			String[] parts = this.href.split("/");
			String lastElement = parts[parts.length - 1];
			if (NumberUtils.isNumber(lastElement)) {
				return BigInteger.valueOf(Long.valueOf(lastElement));
			}
		}
		return null;
	}

}
