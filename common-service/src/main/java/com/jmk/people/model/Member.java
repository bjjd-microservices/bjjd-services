package com.jmk.people.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.people.enums.MemberType;

import io.swagger.annotations.ApiModelProperty;

/**
 * Member
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")
public class Member extends Person  {

  @JsonProperty("memberType")
  private MemberType memberType = null;

  @JsonProperty("joiningDate")
  private LocalDate joiningDate = null;

  @JsonProperty("validity")
  private LocalDate validity = null;

  public Member memberType(MemberType memberType) {
    this.memberType = memberType;
    return this;
  }

  /**
   * Password of the user
   * @return memberType
  **/
  @ApiModelProperty(value = "Password of the user")


  public MemberType getMemberType() {
    return memberType;
  }

  public void setMemberType(MemberType memberType) {
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
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberType, joiningDate, validity, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Member {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
    sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
    sb.append("    validity: ").append(toIndentedString(validity)).append("\n");
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

