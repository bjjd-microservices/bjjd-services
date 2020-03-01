package com.jmk.people.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;

import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.people.enums.MemberType;
import com.jmk.people.model.Person;

/**
 * Member
 */
@Entity
@Table(name = "MEMBER")
@SequenceGenerator(name = "default_gen", sequenceName = "member_seq", allocationSize = 1)
public class Member extends Person  {

  @JsonProperty("memberType")
  private MemberType memberType = null;

  @JsonProperty("joiningDate")
  private LocalDate joiningDate = null;

  @JsonProperty("validity")
  private LocalDate validity = null;

  @JsonProperty("groupId")
  private Integer groupId = null;

  public Member memberType(MemberType memberType) {
    this.memberType = memberType;
    return this;
  }

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

