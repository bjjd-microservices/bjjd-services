package com.jmk.darshan.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Darshan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-12T00:51:00.325+05:30")

public class Darshan   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("visitingDate")
  private LocalDate visitingDate = null;

  /**
   * Visitor Type
   */
  public enum VisitorTypeEnum {
    MEMBER("MEMBER"),
    
    SEVADAR_("SEVADAR,"),
    
    DEVOTEE("DEVOTEE");

    private String value;

    VisitorTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static VisitorTypeEnum fromValue(String text) {
      for (VisitorTypeEnum b : VisitorTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("visitorType")
  private VisitorTypeEnum visitorType = null;

  @JsonProperty("visitorId")
  private String visitorId = null;

  @JsonProperty("visitorName")
  private String visitorName = null;

  @JsonProperty("visitorCity")
  private String visitorCity = null;

  @JsonProperty("visitorState")
  private String visitorState = null;

  @JsonProperty("visitorMobileNo")
  private String visitorMobileNo = null;

  @JsonProperty("reference")
  private String reference = null;

  @JsonProperty("totalMen")
  private Integer totalMen = null;

  @JsonProperty("totalWomen")
  private Integer totalWomen = null;

  @JsonProperty("totalKids")
  private Integer totalKids = null;

  @JsonProperty("totalVisitors")
  private Integer totalVisitors = null;

  @JsonProperty("groupId")
  private Integer groupId = null;

  public Darshan id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Darshan id
   * @return id
  **/
  @ApiModelProperty(value = "Darshan id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Darshan visitingDate(LocalDate visitingDate) {
    this.visitingDate = visitingDate;
    return this;
  }

  /**
   * Visiting date
   * @return visitingDate
  **/
  @ApiModelProperty(value = "Visiting date")

  @Valid

  public LocalDate getVisitingDate() {
    return visitingDate;
  }

  public void setVisitingDate(LocalDate visitingDate) {
    this.visitingDate = visitingDate;
  }

  public Darshan visitorType(VisitorTypeEnum visitorType) {
    this.visitorType = visitorType;
    return this;
  }

  /**
   * Visitor Type
   * @return visitorType
  **/
  @ApiModelProperty(value = "Visitor Type")


  public VisitorTypeEnum getVisitorType() {
    return visitorType;
  }

  public void setVisitorType(VisitorTypeEnum visitorType) {
    this.visitorType = visitorType;
  }

  public Darshan visitorId(String visitorId) {
    this.visitorId = visitorId;
    return this;
  }

  /**
   * Visitor Id
   * @return visitorId
  **/
  @ApiModelProperty(value = "Visitor Id")

@Size(min=1,max=50) 
  public String getVisitorId() {
    return visitorId;
  }

  public void setVisitorId(String visitorId) {
    this.visitorId = visitorId;
  }

  public Darshan visitorName(String visitorName) {
    this.visitorName = visitorName;
    return this;
  }

  /**
   * Visitor name
   * @return visitorName
  **/
  @ApiModelProperty(required = true, value = "Visitor name")
  @NotNull

@Size(min=1,max=255) 
  public String getVisitorName() {
    return visitorName;
  }

  public void setVisitorName(String visitorName) {
    this.visitorName = visitorName;
  }

  public Darshan visitorCity(String visitorCity) {
    this.visitorCity = visitorCity;
    return this;
  }

  /**
   * Visitor City
   * @return visitorCity
  **/
  @ApiModelProperty(value = "Visitor City")

@Size(min=1,max=255) 
  public String getVisitorCity() {
    return visitorCity;
  }

  public void setVisitorCity(String visitorCity) {
    this.visitorCity = visitorCity;
  }

  public Darshan visitorState(String visitorState) {
    this.visitorState = visitorState;
    return this;
  }

  /**
   * Visitor State
   * @return visitorState
  **/
  @ApiModelProperty(value = "Visitor State")

@Size(min=1,max=250) 
  public String getVisitorState() {
    return visitorState;
  }

  public void setVisitorState(String visitorState) {
    this.visitorState = visitorState;
  }

  public Darshan visitorMobileNo(String visitorMobileNo) {
    this.visitorMobileNo = visitorMobileNo;
    return this;
  }

  /**
   * Visitor Mobile Number
   * @return visitorMobileNo
  **/
  @ApiModelProperty(value = "Visitor Mobile Number")

@Size(min=1,max=15) 
  public String getVisitorMobileNo() {
    return visitorMobileNo;
  }

  public void setVisitorMobileNo(String visitorMobileNo) {
    this.visitorMobileNo = visitorMobileNo;
  }

  public Darshan reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Visitor Reference
   * @return reference
  **/
  @ApiModelProperty(value = "Visitor Reference")

@Size(min=1,max=50) 
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Darshan totalMen(Integer totalMen) {
    this.totalMen = totalMen;
    return this;
  }

  /**
   * Total Men
   * @return totalMen
  **/
  @ApiModelProperty(value = "Total Men")


  public Integer getTotalMen() {
    return totalMen;
  }

  public void setTotalMen(Integer totalMen) {
    this.totalMen = totalMen;
  }

  public Darshan totalWomen(Integer totalWomen) {
    this.totalWomen = totalWomen;
    return this;
  }

  /**
   * Total Women
   * @return totalWomen
  **/
  @ApiModelProperty(value = "Total Women")


  public Integer getTotalWomen() {
    return totalWomen;
  }

  public void setTotalWomen(Integer totalWomen) {
    this.totalWomen = totalWomen;
  }

  public Darshan totalKids(Integer totalKids) {
    this.totalKids = totalKids;
    return this;
  }

  /**
   * Total Kids
   * @return totalKids
  **/
  @ApiModelProperty(value = "Total Kids")


  public Integer getTotalKids() {
    return totalKids;
  }

  public void setTotalKids(Integer totalKids) {
    this.totalKids = totalKids;
  }

  public Darshan totalVisitors(Integer totalVisitors) {
    this.totalVisitors = totalVisitors;
    return this;
  }

  /**
   * Total Visitors
   * @return totalVisitors
  **/
  @ApiModelProperty(value = "Total Visitors")


  public Integer getTotalVisitors() {
    return totalVisitors;
  }

  public void setTotalVisitors(Integer totalVisitors) {
    this.totalVisitors = totalVisitors;
  }

  public Darshan groupId(Integer groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * User Group
   * @return groupId
  **/
  @ApiModelProperty(value = "User Group")


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
    Darshan darshan = (Darshan) o;
    return Objects.equals(this.id, darshan.id) &&
        Objects.equals(this.visitingDate, darshan.visitingDate) &&
        Objects.equals(this.visitorType, darshan.visitorType) &&
        Objects.equals(this.visitorId, darshan.visitorId) &&
        Objects.equals(this.visitorName, darshan.visitorName) &&
        Objects.equals(this.visitorCity, darshan.visitorCity) &&
        Objects.equals(this.visitorState, darshan.visitorState) &&
        Objects.equals(this.visitorMobileNo, darshan.visitorMobileNo) &&
        Objects.equals(this.reference, darshan.reference) &&
        Objects.equals(this.totalMen, darshan.totalMen) &&
        Objects.equals(this.totalWomen, darshan.totalWomen) &&
        Objects.equals(this.totalKids, darshan.totalKids) &&
        Objects.equals(this.totalVisitors, darshan.totalVisitors) &&
        Objects.equals(this.groupId, darshan.groupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, visitingDate, visitorType, visitorId, visitorName, visitorCity, visitorState, visitorMobileNo, reference, totalMen, totalWomen, totalKids, totalVisitors, groupId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Darshan {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    visitingDate: ").append(toIndentedString(visitingDate)).append("\n");
    sb.append("    visitorType: ").append(toIndentedString(visitorType)).append("\n");
    sb.append("    visitorId: ").append(toIndentedString(visitorId)).append("\n");
    sb.append("    visitorName: ").append(toIndentedString(visitorName)).append("\n");
    sb.append("    visitorCity: ").append(toIndentedString(visitorCity)).append("\n");
    sb.append("    visitorState: ").append(toIndentedString(visitorState)).append("\n");
    sb.append("    visitorMobileNo: ").append(toIndentedString(visitorMobileNo)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    totalMen: ").append(toIndentedString(totalMen)).append("\n");
    sb.append("    totalWomen: ").append(toIndentedString(totalWomen)).append("\n");
    sb.append("    totalKids: ").append(toIndentedString(totalKids)).append("\n");
    sb.append("    totalVisitors: ").append(toIndentedString(totalVisitors)).append("\n");
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

