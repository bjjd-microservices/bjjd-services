package com.jmk.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.enums.MessageStatus;
import com.jmk.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="username")
	private String username = null;

	@Column(name="display_name")
	private String displayName = null;

	@Column(name="password")
	private String password = null;
	
	@Column(name="security")
	private String security = null;
	
	@Column(name="encryption")
	private String encryption = null;
	
	@Column(name="login_attempt")
	private Integer loginAttempt = null;
	
	@Column(name="fail_attempt")
	private Integer failAttempt = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sms_Sent")
	private MessageStatus smsSent=null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="email_Sent")
	private MessageStatus emailSent=null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status = null;

	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private Profile profile = null;

	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private Set<Identity> identities = new HashSet<>();

	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<>();

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLE",
	joinColumns= {@JoinColumn(name="user_id")},
	inverseJoinColumns= {@JoinColumn(name="role_id")})
	private Set<Role> roles=new HashSet<>();
	
	@Column(name="group_id")
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
	private Long version = 1L;
	
}
