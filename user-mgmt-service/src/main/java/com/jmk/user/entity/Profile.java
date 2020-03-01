package com.jmk.user.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.threeten.bp.LocalDate;

import com.jmk.enums.Gender;
import com.jmk.enums.MaritalStatus;

/**
 * Profile
 */
@Entity
@Table(name = "PROFILE")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

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

	@Column(name = "userType")
	private String userType = null;
	
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
	@Column(name = "VERSION", nullable = false, columnDefinition = "default 1")
	private Long version = 1L;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAltMobileNo() {
		return altMobileNo;
	}

	public void setAltMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
