package com.jmk.people.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jmk.people.model.Address;
import com.jmk.people.model.Identity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Person
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

public class Person   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("dateOfBirth")
  private LocalDate dateOfBirth = null;

  /**
   * Person Gender
   */
  public enum GenderEnum {
    M("M"),
    
    F("F");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenderEnum fromValue(String text) {
      for (GenderEnum b : GenderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender = null;

  /**
   * Marital Status
   */
  public enum MaritalStatusEnum {
    M("M"),
    
    S("S");

    private String value;

    MaritalStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MaritalStatusEnum fromValue(String text) {
      for (MaritalStatusEnum b : MaritalStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("maritalStatus")
  private MaritalStatusEnum maritalStatus = null;

  @JsonProperty("emailId")
  private String emailId = null;

  @JsonProperty("photoId")
  private String photoId = null;

  @JsonProperty("mobileNo")
  private String mobileNo = null;

  @JsonProperty("altMobileNo")
  private String altMobileNo = null;

  @JsonProperty("addresses")
  @Valid
  private List<Address> addresses = null;

  @JsonProperty("identities")
  @Valid
  private List<Identity> identities = null;

  /**
   * Password of the user
   */
  public enum StatusEnum {
    A("A"),
    
    I("I");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("groupId")
  private Integer groupId = null;

  public Person id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * user id
   * @return id
  **/
  @ApiModelProperty(value = "user id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Person userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * User name of the member
   * @return userName
  **/
  @ApiModelProperty(required = true, value = "User name of the member")
  @NotNull

@Size(min=1,max=50) 
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Person userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * User name of the member
   * @return userId
  **/
  @ApiModelProperty(value = "User name of the member")

@Size(min=1,max=50) 
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Person firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Password of the user
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "Password of the user")
  @NotNull

@Size(min=1,max=50) 
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
   * @return lastName
  **/
  @ApiModelProperty(value = "Password of the user")

@Size(min=1,max=50) 
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

  public Person gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Person Gender
   * @return gender
  **/
  @ApiModelProperty(value = "Person Gender")


  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public Person maritalStatus(MaritalStatusEnum maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Marital Status
   * @return maritalStatus
  **/
  @ApiModelProperty(value = "Marital Status")


  public MaritalStatusEnum getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(MaritalStatusEnum maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public Person emailId(String emailId) {
    this.emailId = emailId;
    return this;
  }

  /**
   * Email id
   * @return emailId
  **/
  @ApiModelProperty(value = "Email id")

@Size(min=1,max=150) 
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
   * @return photoId
  **/
  @ApiModelProperty(value = "Photo Id")

@Size(min=1,max=150) 
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
   * @return mobileNo
  **/
  @ApiModelProperty(value = "Primary Mobile number")

@Size(min=1,max=50) 
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
   * @return altMobileNo
  **/
  @ApiModelProperty(value = "Secondary Mobile number")

@Size(min=1,max=50) 
  public String getAltMobileNo() {
    return altMobileNo;
  }

  public void setAltMobileNo(String altMobileNo) {
    this.altMobileNo = altMobileNo;
  }

  public Person addresses(List<Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public Person addAddressesItem(Address addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<Address>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  /**
   * Get addresses
   * @return addresses
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public Person identities(List<Identity> identities) {
    this.identities = identities;
    return this;
  }

  public Person addIdentitiesItem(Identity identitiesItem) {
    if (this.identities == null) {
      this.identities = new ArrayList<Identity>();
    }
    this.identities.add(identitiesItem);
    return this;
  }

  /**
   * Get identities
   * @return identities
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Identity> getIdentities() {
    return identities;
  }

  public void setIdentities(List<Identity> identities) {
    this.identities = identities;
  }

  public Person status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Password of the user
   * @return status
  **/
  @ApiModelProperty(value = "Password of the user")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Person groupId(Integer groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * Group Id
   * @return groupId
  **/
  @ApiModelProperty(value = "Group Id")


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
    Person person = (Person) o;
    return Objects.equals(this.id, person.id) &&
        Objects.equals(this.userName, person.userName) &&
        Objects.equals(this.userId, person.userId) &&
        Objects.equals(this.firstName, person.firstName) &&
        Objects.equals(this.lastName, person.lastName) &&
        Objects.equals(this.dateOfBirth, person.dateOfBirth) &&
        Objects.equals(this.gender, person.gender) &&
        Objects.equals(this.maritalStatus, person.maritalStatus) &&
        Objects.equals(this.emailId, person.emailId) &&
        Objects.equals(this.photoId, person.photoId) &&
        Objects.equals(this.mobileNo, person.mobileNo) &&
        Objects.equals(this.altMobileNo, person.altMobileNo) &&
        Objects.equals(this.addresses, person.addresses) &&
        Objects.equals(this.identities, person.identities) &&
        Objects.equals(this.status, person.status) &&
        Objects.equals(this.groupId, person.groupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, userId, firstName, lastName, dateOfBirth, gender, maritalStatus, emailId, photoId, mobileNo, altMobileNo, addresses, identities, status, groupId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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

