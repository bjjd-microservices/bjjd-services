package com.jmk.model.user;

import java.sql.Timestamp;
import java.util.Objects;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Identity
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-12T22:05:50.743+05:30")

public class Identity {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("passportId")
	private String passportId = null;

	@JsonProperty("panId")
	private String panId = null;

	@JsonProperty("aadharId")
	private String aadharId = null;

	@JsonProperty("voterId")
	private String voterId = null;

	@JsonProperty("driverLicenseId")
	private String driverLicenseId = null;

	@JsonProperty("groupId")
	private Integer groupId = null;

	@JsonProperty("createdBy")
	private Integer createdBy = null;

	@JsonProperty("createdOn")
	private Timestamp createdOn = null;

	@JsonProperty("whenModified")
	private Timestamp whenModified = null;

	@JsonProperty("version")
	private Long version = null;

	@JsonIgnore
	private User user;

	/**
	 * user id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "user id")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Identity passportId(String passportId) {
		this.passportId = passportId;
		return this;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the whenModified
	 */
	public Timestamp getWhenModified() {
		return whenModified;
	}

	/**
	 * @param whenModified the whenModified to set
	 */
	public void setWhenModified(Timestamp whenModified) {
		this.whenModified = whenModified;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * User Type
	 * 
	 * @return passportId
	 **/
	@ApiModelProperty(value = "User Type")

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public Identity panId(String panId) {
		this.panId = panId;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return panId
	 **/
	@ApiModelProperty(value = "User Type")

	public String getPanId() {
		return panId;
	}

	public void setPanId(String panId) {
		this.panId = panId;
	}

	public Identity aadharId(String aadharId) {
		this.aadharId = aadharId;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return aadharId
	 **/
	@ApiModelProperty(value = "User Type")

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public Identity voterId(String voterId) {
		this.voterId = voterId;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return voterId
	 **/
	@ApiModelProperty(value = "User Type")

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public Identity driverLicenseId(String driverLicenseId) {
		this.driverLicenseId = driverLicenseId;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return driverLicenseId
	 **/
	@ApiModelProperty(value = "User Type")

	public String getDriverLicenseId() {
		return driverLicenseId;
	}

	public void setDriverLicenseId(String driverLicenseId) {
		this.driverLicenseId = driverLicenseId;
	}

	public Identity groupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	/**
	 * User Group
	 * 
	 * @return groupId
	 **/
	@ApiModelProperty(value = "User Group")
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

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
}
