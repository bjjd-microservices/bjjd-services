package com.jmk.user.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.enums.Gender;
import com.jmk.enums.MaritalStatus;

import io.swagger.annotations.ApiModelProperty;

/**
 * Profile
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-12T22:05:50.743+05:30")

public class Profile {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	@JsonProperty("dateOfBirth")
	private LocalDate dateOfBirth = null;

	@JsonProperty("gender")
	private Gender gender = null;

	@JsonProperty("maritalStatus")
	private MaritalStatus maritalStatus = null;

	@JsonProperty("emailId")
	private String emailId = null;

	@JsonProperty("photoId")
	private String photoId = null;

	@JsonProperty("mobileNo")
	private String mobileNo = null;

	@JsonProperty("altMobileNo")
	private String altMobileNo = null;

	@JsonProperty("userType")
	private String userType = null;

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

	public Profile firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(value = "Password of the user")

	@Size(min = 1, max = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Profile lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(value = "Password of the user")

	@Size(min = 1, max = 50)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Profile dateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	/**
	 * Date of the birth
	 * 
	 * @return dateOfBirth
	 **/
	@ApiModelProperty(value = "Date of the birth")

	@Valid

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Profile gender(Gender gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return gender
	 **/
	@ApiModelProperty(value = "Password of the user")

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Profile maritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
		return this;
	}

	/**
	 * Marital Status of the user
	 * 
	 * @return maritalStatus
	 **/
	@ApiModelProperty(value = "Marital Status of the user")

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Profile emailId(String emailId) {
		this.emailId = emailId;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return emailId
	 **/
	@ApiModelProperty(value = "Password of the user")

	@Size(min = 1, max = 150)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Profile photoId(String photoId) {
		this.photoId = photoId;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return photoId
	 **/
	@ApiModelProperty(value = "Password of the user")

	@Size(min = 1, max = 150)
	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public Profile mobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return mobileNo
	 **/
	@ApiModelProperty(value = "Password of the user")

	@Size(min = 1, max = 50)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Profile altMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return altMobileNo
	 **/
	@ApiModelProperty(value = "Password of the user")

	@Size(min = 1, max = 50)
	public String getAltMobileNo() {
		return altMobileNo;
	}

	public void setAltMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
	}

	public Profile userType(String userType) {
		this.userType = userType;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return userType
	 **/
	@ApiModelProperty(value = "User Type")

	@Size(min = 1, max = 50)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Profile groupId(Integer groupId) {
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
		Profile profile = (Profile) o;
		return Objects.equals(this.id, profile.id) && Objects.equals(this.firstName, profile.firstName)
				&& Objects.equals(this.lastName, profile.lastName)
				&& Objects.equals(this.dateOfBirth, profile.dateOfBirth) && Objects.equals(this.gender, profile.gender)
				&& Objects.equals(this.maritalStatus, profile.maritalStatus)
				&& Objects.equals(this.emailId, profile.emailId) && Objects.equals(this.photoId, profile.photoId)
				&& Objects.equals(this.mobileNo, profile.mobileNo)
				&& Objects.equals(this.altMobileNo, profile.altMobileNo)
				&& Objects.equals(this.userType, profile.userType) && Objects.equals(this.groupId, profile.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, dateOfBirth, gender, maritalStatus, emailId, photoId, mobileNo,
				altMobileNo, userType, groupId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Profile {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
		sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
		sb.append("    photoId: ").append(toIndentedString(photoId)).append("\n");
		sb.append("    mobileNo: ").append(toIndentedString(mobileNo)).append("\n");
		sb.append("    altMobileNo: ").append(toIndentedString(altMobileNo)).append("\n");
		sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
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
