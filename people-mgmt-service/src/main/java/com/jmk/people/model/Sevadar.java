package com.jmk.people.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.people.enums.SevaDays;
import com.jmk.people.enums.SevadarCategory;

import io.swagger.annotations.ApiModelProperty;

/**
 * Sevadar
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")
public class Sevadar extends Person  {
  /**
   * Sevadar Category
   */

  @JsonProperty("sevadarCategory")
  private SevadarCategory sevadarCategory = null;

  @JsonProperty("sevaDays")
  @Valid
  private Collection<SevaDays> sevaDays = null;

  @JsonProperty("joiningDate")
  private LocalDate joiningDate = null;

  public Sevadar sevadarCategory(SevadarCategory sevadarCategory) {
    this.sevadarCategory = sevadarCategory;
    return this;
  }

  /**
   * Sevadar Category
   * @return sevadarCategory
  **/
  @ApiModelProperty(value = "Sevadar Category")


  public SevadarCategory getSevadarCategory() {
    return sevadarCategory;
  }

  public void setSevadarCategory(SevadarCategory sevadarCategory) {
    this.sevadarCategory = sevadarCategory;
  }

  public Sevadar sevaDays(List<SevaDays> sevaDays) {
    this.sevaDays = sevaDays;
    return this;
  }

  public Sevadar addSevaDaysItem(SevaDays sevaDaysItem) {
    if (this.sevaDays == null) {
      this.sevaDays = new ArrayList<SevaDays>();
    }
    this.sevaDays.add(sevaDaysItem);
    return this;
  }

  /**
   * Get sevaDays
   * @return sevaDays
  **/
  @ApiModelProperty(value = "")
  public Collection<SevaDays> getSevaDays() {
    return sevaDays;
  }

  public void setSevaDays(List<SevaDays> sevaDays) {
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
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sevadarCategory, sevaDays, joiningDate, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sevadar {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    sevadarCategory: ").append(toIndentedString(sevadarCategory)).append("\n");
    sb.append("    sevaDays: ").append(toIndentedString(sevaDays)).append("\n");
    sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
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

