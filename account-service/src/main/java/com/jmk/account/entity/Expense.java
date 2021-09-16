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

import com.jmk.account.enums.PaymentMode;
import com.jmk.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Expense
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EXPENSE")
public class Expense implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	@Column(name="modified_by")
	private Long modifiedBy = null;
	
	@Column(name="when_modified")
	private LocalDateTime whenModified=null;
	
	@Version
	private Long version=null;

}
