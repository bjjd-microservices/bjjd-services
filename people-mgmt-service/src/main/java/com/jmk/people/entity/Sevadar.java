package com.jmk.people.entity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;

import org.threeten.bp.LocalDate;

import com.jmk.people.enums.SevaDays;
import com.jmk.people.enums.SevadarCategory;

import io.swagger.annotations.ApiModelProperty;

/**
 * Sevadar
 */
@Entity
@Table(name = "SEVADAR")
@DiscriminatorValue("SEVADAR")
@PrimaryKeyJoinColumn(name="ID",referencedColumnName="ID")
public class Sevadar extends Person  {

  @Enumerated(EnumType.STRING)
  @Column(name="sevadar_category")
  private SevadarCategory sevadarCategory = null;

  @ElementCollection(fetch=FetchType.EAGER)
  @CollectionTable(name = "sevadar_sevadays", joinColumns = @JoinColumn(name = "sevadar_id"))
  @Enumerated(EnumType.STRING)
  @Column(name="seva_days")
  private Collection<SevaDays> sevaDays = null;

  @Column(name="joining_date")
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

