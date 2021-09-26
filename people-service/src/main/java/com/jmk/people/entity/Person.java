package com.jmk.people.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.enums.Gender;
import com.jmk.enums.MaritalStatus;
import com.jmk.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PERSON")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="person_type",discriminatorType=DiscriminatorType.STRING)//Optional to define the type of Person
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "username")
	private String username = null;

	@Column(name="user_id")
	private Long userId = null;

	@Column(name = "first_name")
	private String firstName = null;

	@Column(name = "last_name")
	private String lastName = null;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "marital_status")
	private MaritalStatus maritalStatus = null;

	@Column(name = "email_id")
	private String emailId = null;

	@Column(name = "photo_id")
	private String photoId = null;

	@Column(name = "mobile_no")
	private String mobileNo = null;

	@Column(name = "alt_mobile_no")
	private String altMobileNo = null;

	@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
	private Set<Identity> identities = new HashSet<>();

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status = null;

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

