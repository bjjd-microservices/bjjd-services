package com.jmk.account.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.account.enums.DonorType;
import com.jmk.account.enums.PaymentMode;
import com.jmk.enums.MessageStatus;
import com.jmk.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Donation
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DONATION")
public class Donation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "donation_date")
	private LocalDate donationDate = null;

	@Column(name = "donor_id")
	private Long donorId = null;

	@Column(name = "donor_name")
	private String donorName = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "donor_type")
	private DonorType donorType = null;
	
	@JsonProperty("donorAddress")
	private String donorAddress=null;
	
	@Column(name = "donor_city")
	private String donorCity = null;

	@Column(name="donor_state")
	private String donorState = null;


	@Column(name = "donor_mobileNo")
	private String donorMobileNo = null;

	@JsonProperty("donor_aadhar_no")
	private String donorAadharNo=null;
	
	@Column(name = "donor_pan_no")
	private String donorPANNo = null;

	@Column(name = "amount")
	private BigDecimal amount = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="payment_mode")
	private PaymentMode paymentMode;
	
	@Column(name="payment_mode_reference")
	private String paymentModeReference;
	
	@Column(name="amount_deposited_into_bank")
	private String amountDepositedInToBank;

	@Column(name = "project_id")
	private Long projectId = null;

	@Column(name="project_code")
	private String projectCode=null;

	@Column(name = "project_name")
	private String projectName = null;
	
	@Column(name = "reference")
	private String reference = null;

	@Column(name = "received_by")
	private String receivedBy = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sms_Sent")
	private MessageStatus smsSent=null;

	@Column(name = "description")
	private String description = null;

	@Column(name = "remarks")
	private String remarks = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status = null;

	@Column(name = "group_id")
	private Integer groupId = null;
	
	@Column(name="created_by")
	private Long createdBy = null;
	
	@Column(name="created_on")
	private LocalDateTime createdOn=null;
	
	@Column(name="modified_by")
	private Long modifiedBy = null;
	
	@Column(name="when_modified")
	private LocalDateTime whenModified=null;
	
	@Version
	private Long version=null;

}
