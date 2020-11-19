package com.jmk.account.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.account.enums.PaymentMode;
import com.jmk.enums.Status;

/**
 * Expense
 */
@Entity
@Table(name = "EXPENSE")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="voucher_no")
	private Long voucherNo;

	@Column(name = "date")
	private LocalDate date = null;
	
	@Column(name="category")
	private String category=null;
	
	@Column(name="item")
	private String item=null;

	@Column(name = "description")
	private String description = null;

	@Column(name = "amount")
	private BigDecimal amount = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="payment_mode")
	private PaymentMode paymentMode;
	
	@Column(name="payment_mode_reference")
	private String paymentModeReference;
	
	@Column(name="withdrawn_from_bank")
	private String withdrawnFromBank;

	@Column(name = "project_id")
	private Long projectId = null;
	
	@Column(name="projectCode")
	private String projectCode=null;

	@Column(name = "project_name")
	private String projectName = null;

	@Column(name = "paid_to")
	private String paidTo = null;

	@Column(name = "remarks")
	private String remarks = null;

	@Column(name = "approved_by")
	private String approvedBy = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status = null;

	@Column(name = "group_id")
	private Integer groupId = null;
	
	@Column(name="created_by")
	private Long createdBy = null;
	
	@Column(name="created_on")
	private LocalDateTime createdOn=null;
	
	@Column(name="when_modified")
	private LocalDateTime whenModified=null;
	
	@Version
	private Long version=null;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the expenseDate
	 */
	public LocalDate getExpenseDate() {
		return date;
	}

	/**
	 * @param expenseDate the expenseDate to set
	 */
	public void setExpenseDate(LocalDate expenseDate) {
		this.date = expenseDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the paidTo
	 */
	public String getPaidTo() {
		return paidTo;
	}

	/**
	 * @param paidTo the paidTo to set
	 */
	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
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
	 * @return the groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseDate=" + date + ", expenseCategory=" + category
				+ ", expenseItem=" + item + ", description=" + description + ", amount=" + amount
				+ ", paymentMode=" + paymentMode + ", paymentModeReference=" + paymentModeReference + ", projectId="
				+ projectId + ", projectName=" + projectName + ", paidTo=" + paidTo + ", remarks=" + remarks
				+ ", approvedBy=" + approvedBy + ", status=" + status + ", groupId=" + groupId + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", whenModified=" + whenModified + ", version=" + version
				+ "]";
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
