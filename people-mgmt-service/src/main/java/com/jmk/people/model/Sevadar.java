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

import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Sevadar
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

public class Sevadar extends Person  {
  /**
   * Sevadar Category
   */
  public enum SevadarCategoryEnum {
    AANRTIK("Aanrtik"),
    
    BAHARI("Bahari"),
    
    RATRI("Ratri");

    private String value;

    SevadarCategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SevadarCategoryEnum fromValue(String text) {
      for (SevadarCategoryEnum b : SevadarCategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sevadarCategory")
  private SevadarCategoryEnum sevadarCategory = null;

  /**
   * Gets or Sets sevaDays
   */
  public enum SevaDaysEnum {
    MONDAY("MONDAY"),
    
    TUESDAY("TUESDAY"),
    
    WEDNESDAY("WEDNESDAY"),
    
    THURSDAY("THURSDAY"),
    
    FRIDAY("FRIDAY"),
    
    SATURDAY("SATURDAY"),
    
    SUNDAY("SUNDAY");

    private String value;

    SevaDaysEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SevaDaysEnum fromValue(String text) {
      for (SevaDaysEnum b : SevaDaysEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sevaDays")
  @Valid
  private List<SevaDaysEnum> sevaDays = null;

  @JsonProperty("joiningDate")
  private LocalDate joiningDate = null;

  @JsonProperty("groupId")
  private Integer groupId = null;

  public Sevadar sevadarCategory(SevadarCategoryEnum sevadarCategory) {
    this.sevadarCategory = sevadarCategory;
    return this;
  }

  /**
   * Sevadar Category
   * @return sevadarCategory
  **/
  @ApiModelProperty(value = "Sevadar Category")


  public SevadarCategoryEnum getSevadarCategory() {
    return sevadarCategory;
  }

  public void setSevadarCategory(SevadarCategoryEnum sevadarCategory) {
    this.sevadarCategory = sevadarCategory;
  }

  public Sevadar sevaDays(List<SevaDaysEnum> sevaDays) {
    this.sevaDays = sevaDays;
    return this;
  }

  public Sevadar addSevaDaysItem(SevaDaysEnum sevaDaysItem) {
    if (this.sevaDays == null) {
      this.sevaDays = new ArrayList<SevaDaysEnum>();
    }
    this.sevaDays.add(sevaDaysItem);
    return this;
  }

  /**
   * Get sevaDays
   * @return sevaDays
  **/
  @ApiModelProperty(value = "")


  public List<SevaDaysEnum> getSevaDays() {
    return sevaDays;
  }

  public void setSevaDays(List<SevaDaysEnum> sevaDays) {
    this.sevaDays = sevaDays;
  }

  public Sevadar joiningDate(LocalDate joiningDate) {
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

  public Sevadar groupId(Integer groupId) {
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
    Sevadar sevadar = (Sevadar) o;
    return Objects.equals(this.sevadarCategory, sevadar.sevadarCategory) &&
        Objects.equals(this.sevaDays, sevadar.sevaDays) &&
        Objects.equals(this.joiningDate, sevadar.joiningDate) &&
        Objects.equals(this.groupId, sevadar.groupId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sevadarCategory, sevaDays, joiningDate, groupId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sevadar {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    sevadarCategory: ").append(toIndentedString(sevadarCategory)).append("\n");
    sb.append("    sevaDays: ").append(toIndentedString(sevaDays)).append("\n");
    sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
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

