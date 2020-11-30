package com.jmk.upload.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.account.enums.PaymentMode;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModelProperty;

/**
 * Expense
 */
@XmlRootElement
public class Expense extends Base {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3084474093990281894L;

	@JsonProperty("id")
	private Long id = null;
	
	@JsonProperty("voucherNo")
	private Long voucherNo;

	@JsonProperty("date")
	private LocalDate date = null;
	
	@JsonProperty("category")
	private String category=null;
	
	@JsonProperty("item")
	private String item=null; 

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("amount")
	private BigDecimal amount = null;

	@JsonProperty("paymentMode")
	private PaymentMode paymentMode;

	@JsonProperty("paymentModeReference")
	private String paymentModeReference;
	
	@JsonProperty("withdrawnFromBank")
	private String withdrawnFromBank;

	@JsonProperty("projectId")
	private Long projectId = null;
	
	@JsonProperty("projectCode")
	private String projectCode=null;

	@JsonProperty("projectName")
	private String projectName = null;

	@JsonProperty("paidTo")
	private String paidTo = null;

	@JsonProperty("remarks")
	private String remarks = null;

	@JsonProperty("approvedBy")
	private String approvedBy = null;

	@JsonProperty("status")
	private Status status = null;

	@JsonProperty("groupId")
	private Integer groupId = null;

	@JsonProperty
	private Long createdBy = null;

	@JsonProperty
	private LocalDateTime createdOn = null;
	
	private Long modifiedBy = null;

	@JsonProperty
	private LocalDateTime whenModified = null;

	@JsonProperty
	private Long version = null;

	public Expense id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the paymentMode
	 */
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the paymentModeReference
	 */
	public String getPaymentModeReference() {
		return paymentModeReference;
	}

	/**
	 * @param paymentModeReference the paymentModeReference to set
	 */
	public void setPaymentModeReference(String paymentModeReference) {
		this.paymentModeReference = paymentModeReference;
	}

	/**
	 * @return the createdOn
	 */
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the whenModified
	 */
	public LocalDateTime getWhenModified() {
		return whenModified;
	}

	/**
	 * @param whenModified the whenModified to set
	 */
	public void setWhenModified(LocalDateTime whenModified) {
		this.whenModified = whenModified;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * donation id
	 * 
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
		this.date = expenseDate;
		return this;
	}

	/**
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * Donation date
	 * 
	 * @return expenseDate
	 **/
	@ApiModelProperty(value = "Donation date")

	@Valid

	public LocalDate getExpenseDate() {
		return date;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.date = expenseDate;
	}

	public Expense description(String description) {
		this.description = description;
		return this;
	}
	
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the withdrawnFromBank
	 */
	public String getWithdrawnFromBank() {
		return withdrawnFromBank;
	}

	/**
	 * @param withdrawnFromBank the withdrawnFromBank to set
	 */
	public void setWithdrawnFromBank(String withdrawnFromBank) {
		this.withdrawnFromBank = withdrawnFromBank;
	}

	/**
	 * Password of the user
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Password of the user")

	@Size(min = 1, max = 250)
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
	 * Amount minimum: 0.01 maximum: 9999999999999.99
	 * 
	 * @return amount
	 **/
	@ApiModelProperty(value = "Amount")

	@Valid
	@DecimalMin("0.01")
	@DecimalMax("9999999999999.99")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Expense projectId(Long projectId) {
		this.projectId = projectId;
		return this;
	}

	/**
	 * Project Id
	 * 
	 * @return projectId
	 **/
	@ApiModelProperty(value = "Project Id")

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Expense projectName(String projectName) {
		this.projectName = projectName;
		return this;
	}

	/**
	 * Project Id
	 * 
	 * @return projectName
	 **/
	@ApiModelProperty(required = true, value = "Project Id")
	@NotNull

	@Size(min = 1, max = 150)
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
	 * 
	 * @return paidTo
	 **/
	@ApiModelProperty(value = "Project Id")

	@Size(min = 1, max = 150)
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
	 * 
	 * @return remarks
	 **/
	@ApiModelProperty(value = "Password of the user")

	@Size(min = 1, max = 250)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Expense approvedBy(String approvedBy) {
		this.approvedBy = approvedBy;
		return this;
	}

	/**
	 * User Group
	 * 
	 * @return approvedBy
	 **/
	@ApiModelProperty(value = "User Group")

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Expense status(Status status) {
		this.status = status;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "Password of the user")

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Expense groupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	/**
	 * User Group
	 * 
	 * @return groupId
	 **/
	@ApiModelProperty(value = "User Group")

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
	

	/**
	 * @return the modifiedBy
	 */
	public Long getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
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
		return Objects.equals(this.id, expense.id) && Objects.equals(this.date, expense.date)
				&& Objects.equals(this.description, expense.description) && Objects.equals(this.amount, expense.amount)
				&& Objects.equals(this.projectId, expense.projectId)
				&& Objects.equals(this.projectName, expense.projectName) && Objects.equals(this.paidTo, expense.paidTo)
				&& Objects.equals(this.remarks, expense.remarks) && Objects.equals(this.approvedBy, expense.approvedBy)
				&& Objects.equals(this.status, expense.status) && Objects.equals(this.groupId, expense.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, description, amount, projectId, projectName, paidTo, remarks, approvedBy,
				status, groupId);
	}
	
	



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Expense [id=" + id + ", voucherNo=" + voucherNo + ", date=" + date + ", category=" + category
				+ ", item=" + item + ", description=" + description + ", amount=" + amount + ", paymentMode="
				+ paymentMode + ", paymentModeReference=" + paymentModeReference + ", withdrawnFromBank="
				+ withdrawnFromBank + ", projectId=" + projectId + ", projectCode=" + projectCode + ", projectName="
				+ projectName + ", paidTo=" + paidTo + ", remarks=" + remarks + ", approvedBy=" + approvedBy
				+ ", status=" + status + ", groupId=" + groupId + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", whenModified=" + whenModified + ", version=" + version + "]";
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

	/**
	 * @return the expenseCategory
	 */
	public String getExpenseCategory() {
		return category;
	}

	/**
	 * @param expenseCategory the expenseCategory to set
	 */
	public void setExpenseCategory(String expenseCategory) {
		this.category = expenseCategory;
	}

	/**
	 * @return the expenseItem
	 */
	public String getExpenseItem() {
		return item;
	}

	/**
	 * @param expenseItem the expenseItem to set
	 */
	public void setExpenseItem(String expenseItem) {
		this.item = expenseItem;
	}

	/**
	 * @return the voucherNo
	 */
	public Long getVoucherNo() {
		return voucherNo;
	}

	/**
	 * @param voucherNo the voucherNo to set
	 */
	public void setVoucherNo(Long voucherNo) {
		this.voucherNo = voucherNo;
	}
	
	
	
	
}
