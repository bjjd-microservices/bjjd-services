package com.jmk.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.enums.AddressType;
import com.jmk.enums.MessageStatus;
import com.jmk.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Address
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "house_no")
	private String houseNo = null;

	@Column(name = "address_line1")
	private String addressLine1 = null;

	@Column(name = "address_line2")
	private String addressLine2 = null;

	@Column(name = "city")
	private String city = null;

	@Column(name = "state")
	private String state = null;

	@Column(name = "country")
	private String country = null;

	@Column(name = "pincode")
	private String pinCode = null;

	@Column(name = "landmark")
	private String landmark = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "address_type")
	private AddressType addressType = null;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "group_id")
	private Integer groupId = null;

	@Column(name = "created_by")
	private Long createdBy = null;

	@Column(name = "created_on")
	private LocalDateTime createdOn = null;
	
	@Column(name="modified_by")
	private Long modifiedBy = null;

	@Column(name = "when_modified")
	private LocalDateTime whenModified = null;

	@Version
	private Long version = 1L;

}
