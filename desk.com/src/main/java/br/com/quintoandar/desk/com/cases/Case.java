package br.com.quintoandar.desk.com.cases;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.com.quintoandar.desk.com.common.DeskLink;
import br.com.quintoandar.desk.com.common.DeskObj;
import br.com.quintoandar.desk.com.users.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Case extends DeskObj {
	private static final long serialVersionUID = -1154351927373520883L;

	@JsonProperty("external_id")
	String externalId;
	String blurb;
	String subject;
	/**
	 * 1 - lowest
	 * 10 - highest
	 */
	Integer priority = 1;
	String description;
	CaseStatus status;
	CaseType type;

	Message message;

	List<String> labels = new LinkedList<String>();

	List<BigInteger> labels_ids = new LinkedList<BigInteger>();

	@JsonProperty("_links")
	Map<String, DeskLink> links = new TreeMap<String, DeskLink>();

	/**
	 * qna public url
	 */
	@JsonProperty("public_url")
	public String publicUrl;

	@JsonProperty("changed_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date changedAt = new Date();

	@JsonProperty("active_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date activeAt;

	@JsonProperty("received_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date receivedAt = new Date();

	@JsonProperty("locked_until")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date lockedUntil;

	@JsonProperty("first_opened_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date firstOpenedAt;

	@JsonProperty("opened_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date openedAt;

	@JsonProperty("first_resolved_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date firstResolvedAt;

	@JsonProperty("resolved_at")
	@JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TIMEZONE)
	Date resolvedAt;

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
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

	public List<BigInteger> getLabels_ids() {
		return labels_ids;
	}

	public void setLabels_ids(List<BigInteger> labels_ids) {
		this.labels_ids = labels_ids;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Map<String, DeskLink> getLinks() {
		return links;
	}

	public void setLinks(Map<String, DeskLink> links) {
		this.links = links;
	}

	/**
	 * For when case is CaseType.qna
	 * @return
	 */
	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	public Date getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	public Date getActiveAt() {
		return activeAt;
	}

	public void setActiveAt(Date activeAt) {
		this.activeAt = activeAt;
	}

	public Date getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public Date getLockedUntil() {
		return lockedUntil;
	}

	public void setLockedUntil(Date lockedUntil) {
		this.lockedUntil = lockedUntil;
	}

	public Date getFirstOpenedAt() {
		return firstOpenedAt;
	}

	public void setFirstOpenedAt(Date firstOpenedAt) {
		this.firstOpenedAt = firstOpenedAt;
	}

	public Date getOpenedAt() {
		return openedAt;
	}

	public void setOpenedAt(Date openedAt) {
		this.openedAt = openedAt;
	}

	public Date getFirstResolvedAt() {
		return firstResolvedAt;
	}

	public void setFirstResolvedAt(Date firstResolvedAt) {
		this.firstResolvedAt = firstResolvedAt;
	}

	public Date getResolvedAt() {
		return resolvedAt;
	}

	public void setResolvedAt(Date resolvedAt) {
		this.resolvedAt = resolvedAt;
	}

	public BigInteger getAssignedUserId() {
		if (this.links != null && this.links.containsKey("assigned_user") && this.links.get("assigned_user") != null) {
			return this.links.get("assigned_user").getObjectId();
		}
		return null;
	}

	/**
	 * Adds a link 'assigned_user' to this Case links.
	 * @param assigned
	 */
	public void setAssignedUser(User assigned) {
		assigned.addToLinks(getLinks(), "assigned_user");
	}
}
