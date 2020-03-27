package com.jmk.user.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Identity
 */
@Entity
@Table(name = "IDENTITY")
public class Identity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "passport_id")
	private String passportId = null;

	@Column(name = "pan_id")
	private String panId = null;

	@Column(name = "aadhar_id")
	private String aadharId = null;

	@Column(name = "voter_id")
	private String voterId = null;

	@Column(name = "driver_license_id")
	private String driverLicenseId = null;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name="group_id")
	private Integer groupId = null;
	
	@Column(name="created_by")
	private Integer createdBy = null;
	
	@Column(name="created_on")
	private Timestamp createdOn=null;
	
	@Column(name="when_modified")
	private Timestamp whenModified=null;
	
	@Version
	private Long version = 1L;

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Identity identity = (Identity) o;
		return Objects.equals(this.id, identity.id) && Objects.equals(this.passportId, identity.passportId)
				&& Objects.equals(this.panId, identity.panId) && Objects.equals(this.aadharId, identity.aadharId)
				&& Objects.equals(this.voterId, identity.voterId)
				&& Objects.equals(this.driverLicenseId, identity.driverLicenseId)
				&& Objects.equals(this.groupId, identity.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, passportId, panId, aadharId, voterId, driverLicenseId, groupId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Identity {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    passportId: ").append(toIndentedString(passportId)).append("\n");
		sb.append("    panId: ").append(toIndentedString(panId)).append("\n");
		sb.append("    aadharId: ").append(toIndentedString(aadharId)).append("\n");
		sb.append("    voterId: ").append(toIndentedString(voterId)).append("\n");
		sb.append("    driverLicenseId: ").append(toIndentedString(driverLicenseId)).append("\n");
		sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public String getPanId() {
		return panId;
	}

	public void setPanId(String panId) {
		this.panId = panId;
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getDriverLicenseId() {
		return driverLicenseId;
	}

	public void setDriverLicenseId(String driverLicenseId) {
		this.driverLicenseId = driverLicenseId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getWhenModified() {
		return whenModified;
	}

	public void setWhenModified(Timestamp whenModified) {
		this.whenModified = whenModified;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
