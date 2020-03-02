package com.jmk.people.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.threeten.bp.LocalDate;

import com.jmk.enums.Gender;
import com.jmk.enums.MaritalStatus;
import com.jmk.enums.Status;

/**
 * Person
 */
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "username")
	private String username = null;

	@Column(name="user_id")
	private Long userId = null;

	@Column(name = "first_name")
	private String firstName = null;

	@Column(name = "last_name")
	private String lastName = null;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "marital_status")
	private MaritalStatus maritalStatus = null;

	@Column(name = "email_id")
	private String emailId = null;

	@Column(name = "photo_id")
	private String photoId = null;

	@Column(name = "mobile_no")
	private String mobileNo = null;

	@Column(name = "alt_mobile_no")
	private String altMobileNo = null;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private Set<Identity> identities = new HashSet<>();

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status = null;

	@Column(name = "group_id")
	private Integer groupId = null;

	@Column(name = "created_by")
	private Integer createdBy = null;

	@Column(name = "created_on")
	private Timestamp createdOn = null;

	@Column(name = "when_modified")
	private Timestamp whenModified = null;

	@Version
	@Column(name = "VERSION", nullable = false, columnDefinition = "default 1")
	private Long version = 1L;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the maritalStatus
	 */
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the photoId
	 */
	public String getPhotoId() {
		return photoId;
	}

	/**
	 * @param photoId the photoId to set
	 */
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the altMobileNo
	 */
	public String getAltMobileNo() {
		return altMobileNo;
	}

	/**
	 * @param altMobileNo the altMobileNo to set
	 */
	public void setAltMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
	}

	/**
	 * @return the addresses
	 */
	public Set<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the identities
	 */
	public Set<Identity> getIdentities() {
		return identities;
	}

	/**
	 * @param identities the identities to set
	 */
	public void setIdentities(Set<Identity> identities) {
		this.identities = identities;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

