package com.jmk.account.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Table;

import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.account.enums.DonorType;
import com.jmk.enums.Status;

/**
 * Donation
 */
@Table(name="DONATION")
public class Donation   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("donationDate")
  private LocalDate donationDate = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("projectId")
  private Integer projectId = null;

  @JsonProperty("projectName")
  private String projectName = null;

  
  @JsonProperty("donorType")
  private DonorType donorType = null;

  @JsonProperty("donorId")
  private String donorId = null;

  @JsonProperty("donorName")
  private String donorName = null;

  @JsonProperty("donorCity")
  private String donorCity = null;

  @JsonProperty("donorMobileNo")
  private String donorMobileNo = null;

  @JsonProperty("donorPANNo")
  private String donorPANNo = null;

  @JsonProperty("reference")
  private String reference = null;

  @JsonProperty("receivedBy")
  private Long receivedBy = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("remarks")
  private String remarks = null;


  @JsonProperty("status")
  private Status status = null;

  @JsonProperty("groupId")
  private Integer groupId = null;

  public Donation id(Long id) {
    this.id = id;
    return this;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Donation donation = (Donation) o;
    return Objects.equals(this.id, donation.id) &&
        Objects.equals(this.donationDate, donation.donationDate) &&
        Objects.equals(this.amount, donation.amount) &&
        Objects.equals(this.projectId, donation.projectId) &&
        Objects.equals(this.projectName, donation.projectName) &&
        Objects.equals(this.donorType, donation.donorType) &&
        Objects.equals(this.donorId, donation.donorId) &&
        Objects.equals(this.donorName, donation.donorName) &&
        Objects.equals(this.donorCity, donation.donorCity) &&
        Objects.equals(this.donorMobileNo, donation.donorMobileNo) &&
        Objects.equals(this.donorPANNo, donation.donorPANNo) &&
        Objects.equals(this.reference, donation.reference) &&
        Objects.equals(this.receivedBy, donation.receivedBy) &&
        Objects.equals(this.description, donation.description) &&
        Objects.equals(this.remarks, donation.remarks) &&
        Objects.equals(this.status, donation.status) &&
        Objects.equals(this.groupId, donation.groupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, donationDate, amount, projectId, projectName, donorType, donorId, donorName, donorCity, donorMobileNo, donorPANNo, reference, receivedBy, description, remarks, status, groupId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Donation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    donationDate: ").append(toIndentedString(donationDate)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    donorType: ").append(toIndentedString(donorType)).append("\n");
    sb.append("    donorId: ").append(toIndentedString(donorId)).append("\n");
    sb.append("    donorName: ").append(toIndentedString(donorName)).append("\n");
    sb.append("    donorCity: ").append(toIndentedString(donorCity)).append("\n");
    sb.append("    donorMobileNo: ").append(toIndentedString(donorMobileNo)).append("\n");
    sb.append("    donorPANNo: ").append(toIndentedString(donorPANNo)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    receivedBy: ").append(toIndentedString(receivedBy)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
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

