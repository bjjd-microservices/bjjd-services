package org.jmk.bjjd.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MemberEntity
 */
@Entity
@Table(name="MEMBER")
public class MemberEntity {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO) private Integer id;
	 */

	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
	@GenericGenerator(name = "member_seq", strategy = "org.jmk.bjjd.member.seqgenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "100"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "B_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id = null;*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "firstName")
	private String firstName = null;

	@Column(name = "lastName")
	private String lastName = null;

	@Column(name = "userName")
	private String userName = null;

	@Column(name = "password")
	private String password = null;

	@Column(name = "userType")
	private String userType = null;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	
}
