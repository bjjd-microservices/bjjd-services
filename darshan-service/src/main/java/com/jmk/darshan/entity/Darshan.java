package com.jmk.darshan.entity;

import java.io.Serializable;
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

import com.jmk.darshan.enums.VisitorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Darshan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="DARSHAN")
public class Darshan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "visiting_date")
	private LocalDate visitingDate = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "visitor_type")
	private VisitorType visitorType = null;

	@Column(name = "visitor_id")
	private Long visitorId = null;

	@Column(name = "visitor_name")
	private String visitorName = null;
	
	@Column(name="visitor_addressline")
	private String visitorAddressLine=null;

	@Column(name = "visitor_city")
	private String visitorCity = null;

	@Column(name = "visitor_state")
	private String visitorState = null;

	@Column(name = "visitor_mobileno")
	private String visitorMobileNo = null;

	@Column(name = "reference")
	private String reference = null;

	@Column(name = "total_men")
	private Integer totalMen = null;

	@Column(name = "total_women")
	private Integer totalWomen = null;

	@Column(name = "total_kids")
	private Integer totalKids = null;

	@Column(name = "total_visitors")
	private Integer totalVisitors = null;

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

