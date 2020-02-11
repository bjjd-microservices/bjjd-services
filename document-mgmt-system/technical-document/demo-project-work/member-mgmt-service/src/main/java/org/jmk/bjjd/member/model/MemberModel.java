package org.jmk.bjjd.member.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MemberModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-06T08:07:29.390+05:30")

public class MemberModel   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("userType")
  private String userType = null;

  public MemberModel id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * member id
   * @return id
  **/
  @ApiModelProperty(value = "member id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MemberModel firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the member
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "First name of the member")
  @NotNull

@Size(min=1,max=50) 
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public MemberModel lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the member
   * @return lastName
  **/
  @ApiModelProperty(value = "Last name of the member")

@Size(min=1,max=50) 
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public MemberModel userName(String userName) {
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

  public MemberModel password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password of the member
   * @return password
  **/
  @ApiModelProperty(value = "Password of the member")

@Size(min=1,max=50) 
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public MemberModel userType(String userType) {
    this.userType = userType;
    return this;
  }

  /**
   * User Type
   * @return userType
  **/
  @ApiModelProperty(value = "User Type")

@Size(min=1,max=50) 
  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberModel memberModel = (MemberModel) o;
    return Objects.equals(this.id, memberModel.id) &&
        Objects.equals(this.firstName, memberModel.firstName) &&
        Objects.equals(this.lastName, memberModel.lastName) &&
        Objects.equals(this.userName, memberModel.userName) &&
        Objects.equals(this.password, memberModel.password) &&
        Objects.equals(this.userType, memberModel.userType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, userName, password, userType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MemberModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
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

