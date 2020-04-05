package com.jmk.account.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Expense
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")

public class Expense   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("expenseDate")
  private LocalDate expenseDate = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("projectId")
  private Integer projectId = null;

  @JsonProperty("projectName")
  private String projectName = null;

  @JsonProperty("paidTo")
  private String paidTo = null;

  @JsonProperty("remarks")
  private String remarks = null;

  @JsonProperty("approvedBy")
  private Long approvedBy = null;

  /**
   * Password of the user
   */
  public enum StatusEnum {
    A("A"),
    
    I("I");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("groupId")
  private Integer groupId = null;

  public Expense id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * donation id
   * @return id
  **/
  @ApiModelProperty(value = "donation id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Expense expenseDate(LocalDate expenseDate) {
    this.expenseDate = expenseDate;
    return this;
  }

  /**
   * Donation date
   * @return expenseDate
  **/
  @ApiModelProperty(value = "Donation date")

  @Valid

  public LocalDate getExpenseDate() {
    return expenseDate;
  }

  public void setExpenseDate(LocalDate expenseDate) {
    this.expenseDate = expenseDate;
  }

  public Expense description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Password of the user
   * @return description
  **/
  @ApiModelProperty(value = "Password of the user")

@Size(min=1,max=250) 
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Expense amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Amount
   * minimum: 0.01
   * maximum: 9999999999999.99
   * @return amount
  **/
  @ApiModelProperty(value = "Amount")

  @Valid
@DecimalMin("0.01") @DecimalMax("9999999999999.99") 
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Expense projectId(Integer projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * Project Id
   * @return projectId
  **/
  @ApiModelProperty(value = "Project Id")


  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public Expense projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * Project Id
   * @return projectName
  **/
  @ApiModelProperty(required = true, value = "Project Id")
  @NotNull

@Size(min=1,max=150) 
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public Expense paidTo(String paidTo) {
    this.paidTo = paidTo;
    return this;
  }

  /**
   * Project Id
   * @return paidTo
  **/
  @ApiModelProperty(value = "Project Id")

@Size(min=1,max=150) 
  public String getPaidTo() {
    return paidTo;
  }

  public void setPaidTo(String paidTo) {
    this.paidTo = paidTo;
  }

  public Expense remarks(String remarks) {
    this.remarks = remarks;
    return this;
  }

  /**
   * Password of the user
   * @return remarks
  **/
  @ApiModelProperty(value = "Password of the user")

@Size(min=1,max=250) 
  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public Expense approvedBy(Long approvedBy) {
    this.approvedBy = approvedBy;
    return this;
  }

  /**
   * User Group
   * @return approvedBy
  **/
  @ApiModelProperty(value = "User Group")


  public Long getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(Long approvedBy) {
    this.approvedBy = approvedBy;
  }

  public Expense status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Password of the user
   * @return status
  **/
  @ApiModelProperty(value = "Password of the user")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Expense groupId(Integer groupId) {
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
    Expense expense = (Expense) o;
    return Objects.equals(this.id, expense.id) &&
        Objects.equals(this.expenseDate, expense.expenseDate) &&
        Objects.equals(this.description, expense.description) &&
        Objects.equals(this.amount, expense.amount) &&
        Objects.equals(this.projectId, expense.projectId) &&
        Objects.equals(this.projectName, expense.projectName) &&
        Objects.equals(this.paidTo, expense.paidTo) &&
        Objects.equals(this.remarks, expense.remarks) &&
        Objects.equals(this.approvedBy, expense.approvedBy) &&
        Objects.equals(this.status, expense.status) &&
        Objects.equals(this.groupId, expense.groupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, expenseDate, description, amount, projectId, projectName, paidTo, remarks, approvedBy, status, groupId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Expense {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    expenseDate: ").append(toIndentedString(expenseDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    paidTo: ").append(toIndentedString(paidTo)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    approvedBy: ").append(toIndentedString(approvedBy)).append("\n");
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

