package br.com.quintoandar.desk.com.cases;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.com.quintoandar.desk.com.common.DeskLink;

/**
 * 
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 */
public class Case implements Serializable {
	private static final long serialVersionUID = -1154351927373520883L;
	String external_id;
	String blurb;
	String subject;
	/**
	 * 1 - lowest
	 * 10 - highest
	 */
	Integer priority;
	String description;
	CaseStatus status;
	CaseType type;
	
	Message message;
	
	List<String> labels = new LinkedList<String>();
	
	Map<String, DeskLink> _links = new TreeMap<String, DeskLink>();

	public String getExternal_id() {
		return external_id;
	}

	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	public String getBlurb() {
		return blurb;
	}

	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CaseStatus getStatus() {
		return status;
	}

	public void setStatus(CaseStatus status) {
		this.status = status;
	}

	public CaseType getType() {
		return type;
	}

	public void setType(CaseType type) {
		this.type = type;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Map<String, DeskLink> get_links() {
		return _links;
	}

	public void set_links(Map<String, DeskLink> _links) {
		this._links = _links;
	}
}
