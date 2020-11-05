package com.jmk.account.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.account.enums.DonorType;
import com.jmk.account.enums.PaymentMode;
import com.jmk.enums.MessageStatus;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModelProperty;

/**
 * Donation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")
public class Donation {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("donationDate")
	private LocalDate donationDate = null;

	@JsonProperty("donorId")
	private Long donorId = null;

	@JsonProperty("donorName")
	private String donorName = null;

	@JsonProperty("donorType")
	private DonorType donorType = null;
	
	@JsonProperty("donorAddress")
	private String donorAddress=null;
	
	@JsonProperty("donorCity")
	private String donorCity = null;
	
	@JsonProperty("donorState")
	private String donorState = null;


	@JsonProperty("donorMobileNo")
	private String donorMobileNo = null;


	@JsonProperty("donorAadharNo")
	private String donorAadharNo=null;
	
	@JsonProperty("donorPANNo")
	private String donorPANNo = null;
	
	@JsonProperty("amount")
	private BigDecimal amount = null;
	
	@JsonProperty("paymentMode")
	private PaymentMode paymentMode;
	
	@JsonProperty("paymentModeReference")
	private String paymentModeReference;
	
	@JsonProperty("amountDepositedInToBank")
	private String amountDepositedInToBank;

	@JsonProperty("projectId")
	private Long projectId = null;

	@JsonProperty("projectCode")
	private String projectCode=null;


	@JsonProperty("projectName")
	private String projectName = null;

	@JsonProperty("smsSent")
	private MessageStatus smsSent=null;
	
	@JsonProperty("reference")
	private String reference = null;

	@JsonProperty("receivedBy")
	private String receivedBy = null;
	
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("remarks")
	private String remarks = null;

	@JsonProperty("status")
	private Status status = null;

	@JsonProperty("groupId")
	private Integer groupId = null;

	@JsonProperty
	private Long createdBy = null;

	@JsonProperty
	private LocalDateTime createdOn = null;

	@JsonProperty
	private LocalDateTime whenModified = null;

	@JsonProperty
	private Long version = null;

	public Donation id(Long id) {
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
	 * @return the paymentMode
	 */
	@ApiModelProperty(required = true, value = "Mode of the payment")
	@NotNull
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

	public Donation donationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
		return this;
	}

	/**
	 * Donation date
	 * 
	 * @return donationDate
	 **/

	@Valid
	@ApiModelProperty(required = true, value = "Donation Date")
	@NotNull
	public LocalDate getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}

	public Donation amount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * Amount minimum: 0.01 maximum: 9999999999999.99
	 * 
	 * @return amount
	 **/
	@ApiModelProperty(required = true, value = "Donation Amount")
	@Valid
	@DecimalMin("0.01")
	@DecimalMax("9999999999999.99")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Donation projectId(Long projectId) {
		this.projectId = projectId;
		return this;
	}

	/**
	 * Project Id
	 * 
	 * @return projectId
	 **/
	@ApiModelProperty(required = true, value = "Project Id")
	@NotNull
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Donation projectName(String projectName) {
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
	@Size(min = 1, max = 255)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Donation donorType(DonorType donorType) {
		this.donorType = donorType;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return donorType
	 **/
	@ApiModelProperty(required = true, value = "Donor Type")
	public DonorType getDonorType() {
		return donorType;
	}

	public void setDonorType(DonorType donorType) {
		this.donorType = donorType;
	}

	public Donation donorId(Long donorId) {
		this.donorId = donorId;
		return this;
	}

	/**
	 * Donor Id
	 * 
	 * @return donorId
	 **/
	@ApiModelProperty(value = "Donor Id")
	public Long getDonorId() {
		return donorId;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}
	
	

	/**
	 * @return the amountDepositedInToBank
	 */
	public String getAmountDepositedInToBank() {
		return amountDepositedInToBank;
	}

	/**
	 * @param amountDepositedInToBank the amountDepositedInToBank to set
	 */
	public void setAmountDepositedInToBank(String amountDepositedInToBank) {
		this.amountDepositedInToBank = amountDepositedInToBank;
	}

	public Donation donorName(String donorName) {
		this.donorName = donorName;
		return this;
	}
	
	

	/**
	 * @return the donorAddress
	 */
	public String getDonorAddress() {
		return donorAddress;
	}

	/**
	 * @param donorAddress the donorAddress to set
	 */
	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}

	/**
	 * @return the donorAadharNo
	 */
	public String getDonorAadharNo() {
		return donorAadharNo;
	}

	/**
	 * @param donorAadharNo the donorAadharNo to set
	 */
	public void setDonorAadharNo(String donorAadharNo) {
		this.donorAadharNo = donorAadharNo;
	}

	/**
	 * Donor name
	 * 
	 * @return donorName
	 **/
	@ApiModelProperty(required=true,value = "Donor name")
	@Size(min = 1, max = 255)
	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public Donation donorCity(String donorCity) {
		this.donorCity = donorCity;
		return this;
	}

	/**
	 * Donor name
	 * 
	 * @return donorCity
	 **/
	@ApiModelProperty(required = true, value = "Donor City")
	@Size(min = 1, max = 150)
	public String getDonorCity() {
		return donorCity;
	}

	public void setDonorCity(String donorCity) {
		this.donorCity = donorCity;
	}

	public Donation donorMobileNo(String donorMobileNo) {
		this.donorMobileNo = donorMobileNo;
		return this;
	}

	/**
	 * Donor name
	 * 
	 * @return donorMobileNo
	 **/
	@ApiModelProperty(required = true, value = "Donor Mobile Number")
	@NotNull
	@Size(min = 1, max = 15)
	public String getDonorMobileNo() {
		return donorMobileNo;
	}

	public void setDonorMobileNo(String donorMobileNo) {
		this.donorMobileNo = donorMobileNo;
	}

	public Donation donorPANNo(String donorPANNo) {
		this.donorPANNo = donorPANNo;
		return this;
	}

	/**
	 * Donor name
	 * 
	 * @return donorPANNo
	 **/
	@ApiModelProperty(value = "Donor name")

	@Size(min = 1, max = 15)
	public String getDonorPANNo() {
		return donorPANNo;
	}

	public void setDonorPANNo(String donorPANNo) {
		this.donorPANNo = donorPANNo;
	}

	public Donation reference(String reference) {
		this.reference = reference;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return reference
	 **/
	@ApiModelProperty(value = "Reference")
	@Size(min = 1, max = 150)
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Donation receivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
		return this;
	}

	/**
	 * User Group
	 * 
	 * @return receivedBy
	 **/
	@ApiModelProperty(value = "Received By")
	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public Donation description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Description")
	@Size(min = 1, max = 250)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Donation remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return remarks
	 **/
	@ApiModelProperty(value = "Remarks")
	@Size(min = 1, max = 250)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Donation status(Status status) {
		this.status = status;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "Status")
	public Status getStatus() {
		return status;
	}

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

	public Donation groupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
	
	/**
	 * @return the donorState
	 */
	public String getDonorState() {
		return donorState;
	}

	/**
	 * @param donorState the donorState to set
	 */
	public void setDonorState(String donorState) {
		this.donorState = donorState;
	}

	/**
	 * @return the smsSent
	 */
	public MessageStatus getSmsSent() {
		return smsSent;
	}

	/**
	 * @param smsSent the smsSent to set
	 */
	public void setSmsSent(MessageStatus smsSent) {
		this.smsSent = smsSent;
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
