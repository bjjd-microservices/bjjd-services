package com.jmk.people.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jmk.people.model.Address;
import com.jmk.people.model.Identity;
import com.jmk.people.model.Person;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Member
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

public class Member extends Person  {
  /**
   * Password of the user
   */
  public enum MemberTypeEnum {
    LIFETIME("Lifetime"),
    
    ONEYEAR("OneYear"),
    
    THREEYEAR("ThreeYear"),
    
    FIVEYEAR("FiveYear");

    private String value;

    MemberTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MemberTypeEnum fromValue(String text) {
      for (MemberTypeEnum b : MemberTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("memberType")
  private MemberTypeEnum memberType = null;

  @JsonProperty("joiningDate")
  private LocalDate joiningDate = null;

  @JsonProperty("validity")
  private LocalDate validity = null;

  @JsonProperty("groupId")
  private Integer groupId = null;

  public Member memberType(MemberTypeEnum memberType) {
    this.memberType = memberType;
    return this;
  }

  /**
   * Password of the user
   * @return memberType
  **/
  @ApiModelProperty(value = "Password of the user")


  public MemberTypeEnum getMemberType() {
    return memberType;
  }

  public void setMemberType(MemberTypeEnum memberType) {
    this.memberType = memberType;
  }

  public Member joiningDate(LocalDate joiningDate) {
    this.joiningDate = joiningDate;
    return this;
  }

  /**
   * Date of the birth
   * @return joiningDate
  **/
  @ApiModelProperty(value = "Date of the birth")

  @Valid

  public LocalDate getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(LocalDate joiningDate) {
    this.joiningDate = joiningDate;
  }

  public Member validity(LocalDate validity) {
    this.validity = validity;
    return this;
  }

  /**
   * Date of the birth
   * @return validity
  **/
  @ApiModelProperty(value = "Date of the birth")

  @Valid

  public LocalDate getValidity() {
    return validity;
  }

  public void setValidity(LocalDate validity) {
    this.validity = validity;
  }

  public Member groupId(Integer groupId) {
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
    Member member = (Member) o;
    return Objects.equals(this.memberType, member.memberType) &&
        Objects.equals(this.joiningDate, member.joiningDate) &&
        Objects.equals(this.validity, member.validity) &&
        Objects.equals(this.groupId, member.groupId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberType, joiningDate, validity, groupId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Member {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
    sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
    sb.append("    validity: ").append(toIndentedString(validity)).append("\n");
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

