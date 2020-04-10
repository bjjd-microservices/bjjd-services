package com.jmk.account.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.account.enums.DonorType;
import com.jmk.account.enums.PaymentMode;
import com.jmk.enums.Status;

/**
 * Donation
 */
@Entity
@Table(name = "DONATION")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "donationDate")
	private LocalDate donationDate = null;

	@Column(name = "amount")
	private BigDecimal amount = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="paymentMode")
	private PaymentMode paymentMode;
	
	@Column(name="paymentModeReference")
	private String paymentModeReference;

	@Column(name = "projectId")
	private Integer projectId = null;

	@Column(name = "projectName")
	private String projectName = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "donorType")
	private DonorType donorType = null;

	@Column(name = "donorId")
	private String donorId = null;

	@Column(name = "donorName")
	private String donorName = null;

	@Column(name = "donorCity")
	private String donorCity = null;

	@Column(name = "donorMobileNo")
	private String donorMobileNo = null;

	@Column(name = "donorPANNo")
	private String donorPANNo = null;

	@Column(name = "reference")
	private String reference = null;

	@Column(name = "receivedBy")
	private Long receivedBy = null;

	@Column(name = "description")
	private String description = null;

	@Column(name = "remarks")
	private String remarks = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status = null;

	@Column(name = "groupId")
	private Integer groupId = null;
	
	@Column(name="created_by")
	private Integer createdBy = null;
	
	@Column(name="created_on")
	private Timestamp createdOn=null;
	
	@Column(name="when_modified")
	private Timestamp whenModified=null;
	
	@Version
	private Long version=null;

	public Donation id(Long id) {
		this.id = id;
		return this;
	}
	
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
	public Integer getProjectId() {
		return projectId;
	}



	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
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
	public String getDonorId() {
		return donorId;
	}



	/**
	 * @param donorId the donorId to set
	 */
	public void setDonorId(String donorId) {
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
	public Integer getCreatedBy() {
		return createdBy;
	}



	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
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



	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Donation donation = (Donation) o;
		return Objects.equals(this.id, donation.id) && Objects.equals(this.donationDate, donation.donationDate)
				&& Objects.equals(this.amount, donation.amount) && Objects.equals(this.projectId, donation.projectId)
				&& Objects.equals(this.projectName, donation.projectName)
				&& Objects.equals(this.donorType, donation.donorType) && Objects.equals(this.donorId, donation.donorId)
				&& Objects.equals(this.donorName, donation.donorName)
				&& Objects.equals(this.donorCity, donation.donorCity)
				&& Objects.equals(this.donorMobileNo, donation.donorMobileNo)
				&& Objects.equals(this.donorPANNo, donation.donorPANNo)
				&& Objects.equals(this.reference, donation.reference)
				&& Objects.equals(this.receivedBy, donation.receivedBy)
				&& Objects.equals(this.description, donation.description)
				&& Objects.equals(this.remarks, donation.remarks) && Objects.equals(this.status, donation.status)
				&& Objects.equals(this.groupId, donation.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, donationDate, amount, projectId, projectName, donorType, donorId, donorName, donorCity,
				donorMobileNo, donorPANNo, reference, receivedBy, description, remarks, status, groupId);
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