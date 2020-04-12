package com.jmk.people.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.enums.Gender;
import com.jmk.enums.MaritalStatus;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModelProperty;

/**
 * Person
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")
public class Person {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("username")
	private String username = null;

	@JsonProperty("user_id")
	private Long userId = null;

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

	@JsonProperty("addresses")
	@JsonManagedReference
	private Set<Address> addresses = new HashSet<>();

	@JsonProperty("identities")
	@JsonManagedReference
	private Set<Identity> identities = new HashSet<>();

	@JsonProperty("status")
	private Status status = null;

	@JsonProperty("groupId")
	private Integer groupId = null;

	@JsonProperty
	private Integer createdBy = null;

	@JsonProperty
	private Timestamp createdOn = null;

	@JsonProperty
	private Timestamp whenModified = null;

	@JsonProperty
	private Long version = null;

	public Person id(Long id) {
		this.id = id;
		return this;
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

	public Person username(String username) {
		this.username = username;
		return this;
	}

	/**
	 * User name of the member
	 * 
	 * @return userName
	 **/
	@ApiModelProperty(required = true, value = "User name of the member")
	@NotNull

	@Size(min = 1, max = 50)
	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public Person userId(Long userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * User name of the member
	 * 
	 * @return userId
	 **/
	@ApiModelProperty(value = "User name of the member")

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Person firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(required = true, value = "Password of the user")
	@NotNull

	@Size(min = 1, max = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Person lastName(String lastName) {
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

	public Person dateOfBirth(LocalDate dateOfBirth) {
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

	public Person gender(Gender gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Person Gender
	 * 
	 * @return gender
	 **/
	@ApiModelProperty(value = "Person Gender")

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Person maritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
		return this;
	}

	/**
	 * Marital Status
	 * 
	 * @return maritalStatus
	 **/
	@ApiModelProperty(value = "Marital Status")

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Person emailId(String emailId) {
		this.emailId = emailId;
		return this;
	}

	/**
	 * Email id
	 * 
	 * @return emailId
	 **/
	@ApiModelProperty(value = "Email id")

	@Size(min = 1, max = 150)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Person photoId(String photoId) {
		this.photoId = photoId;
		return this;
	}

	/**
	 * Photo Id
	 * 
	 * @return photoId
	 **/
	@ApiModelProperty(value = "Photo Id")

	@Size(min = 1, max = 150)
	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public Person mobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
		return this;
	}

	/**
	 * Primary Mobile number
	 * 
	 * @return mobileNo
	 **/
	@ApiModelProperty(value = "Primary Mobile number")

	@Size(min = 1, max = 50)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Person altMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
		return this;
	}

	/**
	 * Secondary Mobile number
	 * 
	 * @return altMobileNo
	 **/
	@ApiModelProperty(value = "Secondary Mobile number")

	@Size(min = 1, max = 50)
	public String getAltMobileNo() {
		return altMobileNo;
	}

	public void setAltMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
	}

	public Person addresses(Set<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	public Person addAddressesItem(Address addressesItem) {
		this.addresses.add(addressesItem);
		return this;
	}

	/**
	 * Get addresses
	 * 
	 * @return addresses
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Person identities(Set<Identity> identities) {
		this.identities = identities;
		return this;
	}

	public Person addIdentitiesItem(Identity identitiesItem) {
		this.identities.add(identitiesItem);
		return this;
	}

	/**
	 * Get identities
	 * 
	 * @return identities
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<Identity> getIdentities() {
		return identities;
	}

	public void setIdentities(Set<Identity> identities) {
		this.identities = identities;
	}

	public Person status(Status status) {
		this.status = status;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "Password of the user")

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Person groupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	/**
	 * Group Id
	 * 
	 * @return groupId
	 **/
	@ApiModelProperty(value = "Group Id")

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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		return Objects.equals(this.id, person.id) && Objects.equals(this.username, person.username)
				&& Objects.equals(this.userId, person.userId) && Objects.equals(this.firstName, person.firstName)
				&& Objects.equals(this.lastName, person.lastName)
				&& Objects.equals(this.dateOfBirth, person.dateOfBirth) && Objects.equals(this.gender, person.gender)
				&& Objects.equals(this.maritalStatus, person.maritalStatus)
				&& Objects.equals(this.emailId, person.emailId) && Objects.equals(this.photoId, person.photoId)
				&& Objects.equals(this.mobileNo, person.mobileNo)
				&& Objects.equals(this.altMobileNo, person.altMobileNo)
				&& Objects.equals(this.addresses, person.addresses)
				&& Objects.equals(this.identities, person.identities) && Objects.equals(this.status, person.status)
				&& Objects.equals(this.groupId, person.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, userId, firstName, lastName, dateOfBirth, gender, maritalStatus, emailId,
				photoId, mobileNo, altMobileNo, addresses, identities, status, groupId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Person {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    userName: ").append(toIndentedString(username)).append("\n");
		sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
		sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
		sb.append("    photoId: ").append(toIndentedString(photoId)).append("\n");
		sb.append("    mobileNo: ").append(toIndentedString(mobileNo)).append("\n");
		sb.append("    altMobileNo: ").append(toIndentedString(altMobileNo)).append("\n");
		sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
		sb.append("    identities: ").append(toIndentedString(identities)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

