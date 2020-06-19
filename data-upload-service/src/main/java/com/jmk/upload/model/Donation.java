package com.jmk.upload.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.account.enums.DonorType;
import com.jmk.account.enums.PaymentMode;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModelProperty;

/**
 * Donation
 */
@XmlRootElement
public class Donation extends Base{
	private Long id = null;

	private LocalDate donationDate = null;

	private BigDecimal amount = null;
	
	private PaymentMode paymentMode;
	
	private String paymentModeReference;

	private Long projectId = null;
	
	private String projectCode=null;

	private String projectName = null;

	private DonorType donorType = null;

	private Long donorId = null;

	private String donorName = null;

	private String donorCity = null;

	private String donorMobileNo = null;

	private String donorPANNo = null;

	private String reference = null;

	private Long receivedBy = null;

	private String description = null;

	private String remarks = null;

	private Status status = null;

	private Integer groupId = null;

	private Long createdBy = null;

	private Timestamp createdOn = null;

	private Timestamp whenModified = null;

	private Long version = null;

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
	 * @return the donationDate
	 */
	public LocalDate getDonationDate() {
		return donationDate;
	}

	/**
	 * @param donationDate the donationDate to set
	 */
	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
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
	 * @return the donorType
	 */
	public DonorType getDonorType() {
		return donorType;
	}

	/**
	 * @param donorType the donorType to set
	 */
	public void setDonorType(DonorType donorType) {
		this.donorType = donorType;
	}

	/**
	 * @return the donorId
	 */
	public Long getDonorId() {
		return donorId;
	}

	/**
	 * @param donorId the donorId to set
	 */
	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}

	/**
	 * @return the donorName
	 */
	public String getDonorName() {
		return donorName;
	}

	/**
	 * @param donorName the donorName to set
	 */
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	/**
	 * @return the donorCity
	 */
	public String getDonorCity() {
		return donorCity;
	}

	/**
	 * @param donorCity the donorCity to set
	 */
	public void setDonorCity(String donorCity) {
		this.donorCity = donorCity;
	}

	/**
	 * @return the donorMobileNo
	 */
	public String getDonorMobileNo() {
		return donorMobileNo;
	}

	/**
	 * @param donorMobileNo the donorMobileNo to set
	 */
	public void setDonorMobileNo(String donorMobileNo) {
		this.donorMobileNo = donorMobileNo;
	}

	/**
	 * @return the donorPANNo
	 */
	public String getDonorPANNo() {
		return donorPANNo;
	}

	/**
	 * @param donorPANNo the donorPANNo to set
	 */
	public void setDonorPANNo(String donorPANNo) {
		this.donorPANNo = donorPANNo;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the receivedBy
	 */
	public Long getReceivedBy() {
		return receivedBy;
	}

	/**
	 * @param receivedBy the receivedBy to set
	 */
	public void setReceivedBy(Long receivedBy) {
		this.receivedBy = receivedBy;
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
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the whenModified
	 */
	public Timestamp getWhenModified() {
		return whenModified;
	}

	/**
	 * @param whenModified the whenModified to set
	 */
	public void setWhenModified(Timestamp whenModified) {
		this.whenModified = whenModified;
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
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Donation [id=" + id + ", donationDate=" + donationDate + ", amount=" + amount + ", paymentMode="
				+ paymentMode + ", paymentModeReference=" + paymentModeReference + ", projectId=" + projectId
				+ ", projectName=" + projectName + ", donorType=" + donorType + ", donorId=" + donorId + ", donorName="
				+ donorName + ", donorCity=" + donorCity + ", donorMobileNo=" + donorMobileNo + ", donorPANNo="
				+ donorPANNo + ", reference=" + reference + ", receivedBy=" + receivedBy + ", description="
				+ description + ", remarks=" + remarks + ", status=" + status + ", groupId=" + groupId + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", whenModified=" + whenModified + ", version=" + version
				+ "]";
	}
	
}