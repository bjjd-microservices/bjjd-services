package com.jmk.user.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.enums.MessageStatus;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 */
@Validated
@ApiModel(value = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 8299701584472487470L;

	@JsonProperty("id")
	@ApiModelProperty(value="User Id")
	private Long id;

	@JsonProperty("username")
	@ApiModelProperty(value="User name")
	@Size(min = 1, max = 50)
	@Builder.Default
	private String username = null;

	@JsonProperty("displayName")
	@ApiModelProperty(value="User Display")
	@Builder.Default
	private String displayName = null;

	@JsonProperty("password")
	@Builder.Default
	private String password = null;

	@JsonProperty("security")
	@Builder.Default
	private String security = null;

	@JsonProperty("encryption")
	@Builder.Default
	private String encryption = null;

	@JsonProperty("loginAttempt")
	@Builder.Default
	private Integer loginAttempt = null;

	@JsonProperty("failAttempt")
	@Builder.Default
	private Integer failAttempt = null;

	@JsonProperty("smsSent")
	@Builder.Default
	private MessageStatus smsSent = null;

	@JsonProperty("emailSent")
	@Builder.Default
	private MessageStatus emailSent = null;

	@JsonProperty("status")
	@Builder.Default
	private Status status = null;

	@JsonProperty("profile")
	@Builder.Default
	private Profile profile = null;

	@JsonProperty("identities")
	@Builder.Default
	private Set<Identity> identities = new HashSet<>();

	@JsonProperty("addresses")
	@Builder.Default
	private Set<Address> addresses = new HashSet<>();
	
	@JsonProperty("roles")
	@Builder.Default
	private Set<Role> roles = new HashSet<>();

	@JsonProperty("groupId")
	@Builder.Default
	private Integer groupId = null;

	@JsonProperty("createdBy")
	@Builder.Default
	private Long createdBy = null;

	@JsonProperty("createdOn")
	@Builder.Default
	private LocalDateTime createdOn = null;
	
	@JsonProperty("modifiedBy")
	@Builder.Default
	private Long modifiedBy = null;

	@JsonProperty("whenModified")
	@Builder.Default
	private LocalDateTime whenModified = null;

	@JsonProperty("version")
	@Builder.Default
	private Long version = null;

	public User addRolesItem(Role rolesItem) {
		if (this.roles == null) {
			this.roles = new HashSet<Role>();
		}
		this.roles.add(rolesItem);
		return this;
	}
	
	public User addIdentitiesItem(Identity identitiesItem) {
		this.identities.add(identitiesItem);
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

	public Integer getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(Integer loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public Integer getFailAttempt() {
		return failAttempt;
	}

	public void setFailAttempt(Integer failAttempt) {
		this.failAttempt = failAttempt;
	}

	public MessageStatus getSmsSent() {
		return smsSent;
	}

	public void setSmsSent(MessageStatus smsSent) {
		this.smsSent = smsSent;
	}

	public MessageStatus getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(MessageStatus emailSent) {
		this.emailSent = emailSent;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Identity> getIdentities() {
		return identities;
	}

	public void setIdentities(Set<Identity> identities) {
		this.identities = identities;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getWhenModified() {
		return whenModified;
	}

	public void setWhenModified(LocalDateTime whenModified) {
		this.whenModified = whenModified;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

}
