package com.jmk.people.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.people.model.Person;

import io.swagger.annotations.ApiModelProperty;

/**
 * Devotee
 */
@Entity
@Table(name = "DEVOTEE")
@SequenceGenerator(name = "default_gen", sequenceName = "devotee_seq", allocationSize = 1)
public class Devotee extends Person  {
  @JsonProperty("devoteeType")
  private String devoteeType = null;

  @JsonProperty("groupId")
  private Integer groupId = null;

  public Devotee devoteeType(String devoteeType) {
    this.devoteeType = devoteeType;
    return this;
  }

  /**
   * devotee id
   * @return devoteeType
  **/
  @ApiModelProperty(value = "devotee id")


  public String getDevoteeType() {
    return devoteeType;
  }

  public void setDevoteeType(String devoteeType) {
    this.devoteeType = devoteeType;
  }

  public Devotee groupId(Integer groupId) {
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
    Devotee devotee = (Devotee) o;
    return Objects.equals(this.devoteeType, devotee.devoteeType) &&
        Objects.equals(this.groupId, devotee.groupId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(devoteeType, groupId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Devotee {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    devoteeType: ").append(toIndentedString(devoteeType)).append("\n");
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

