package com.jmk.user.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.enums.MessageSent;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-12T22:05:50.743+05:30")
public class User {
	@JsonProperty("id")
	private Long id;

	@JsonProperty("username")
	private String username = null;

	@JsonProperty("displayName")
	private String displayName = null;

	@JsonProperty("password")
	private String password = null;

	@JsonProperty("security")
	private String security = null;

	@JsonProperty("encryption")
	private String encryption = null;

	@JsonProperty("loginAttempt")
	private Integer loginAttempt = null;

	@JsonProperty("failAttempt")
	private Integer failAttempt = null;

	@JsonProperty("smsSent")
	private MessageSent smsSent = null;

	@JsonProperty("emailSent")
	private MessageSent emailSent = null;

	@JsonProperty("status")
	private Status status = null;

	@JsonProperty("profile")
	private Profile profile = null;

	@JsonProperty("identities")
	private Set<Identity> identities = new HashSet<>();

	@JsonProperty("addresses")
	private Set<Address> addresses = new HashSet<>();
	
	@JsonProperty("roles")
	private Set<Role> roles = new HashSet<>();

	@JsonProperty("groupId")
	private Integer groupId = null;

	@JsonProperty("createdBy")
	private Long createdBy = null;

	@JsonProperty("createdOn")
	private LocalDateTime createdOn = null;

	@JsonProperty("whenModified")
	private LocalDateTime whenModified = null;

	@JsonProperty("version")
	private Long version = null;

	/**
	 * user id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "user id")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the security
	 */
	public String getSecurity() {
		return security;
	}

	/**
	 * @param security the security to set
	 */
	public void setSecurity(String security) {
		this.security = security;
	}

	/**
	 * @return the encryption
	 */
	public String getEncryption() {
		return encryption;
	}

	/**
	 * @param encryption the encryption to set
	 */
	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

	/**
	 * @return the loginAttempt
	 */
	public Integer getLoginAttempt() {
		return loginAttempt;
	}

	/**
	 * @param loginAttempt the loginAttempt to set
	 */
	public void setLoginAttempt(Integer loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	/**
	 * @return the failAttempt
	 */
	public Integer getFailAttempt() {
		return failAttempt;
	}

	/**
	 * @param failAttempt the failAttempt to set
	 */
	public void setFailAttempt(Integer failAttempt) {
		this.failAttempt = failAttempt;
	}

	/**
	 * @return the smsSent
	 */
	public MessageSent getSmsSent() {
		return smsSent;
	}

	/**
	 * @param smsSent the smsSent to set
	 */
	public void setSmsSent(MessageSent smsSent) {
		this.smsSent = smsSent;
	}

	/**
	 * @return the emailSent
	 */
	public MessageSent getEmailSent() {
		return emailSent;
	}

	/**
	 * @param emailSent the emailSent to set
	 */
	public void setEmailSent(MessageSent emailSent) {
		this.emailSent = emailSent;
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

	public User username(String username) {
		this.username = username;
		return this;
	}

	/**
	 * User name
	 * 
	 * @return username
	 **/
	@ApiModelProperty(value = "User name")

	@Size(min = 1, max = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User displayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	/**
	 * User name
	 * 
	 * @return displayName
	 **/
	@ApiModelProperty(value = "User name")

	@Size(min = 1, max = 50)
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public User password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return password
	 **/
	@ApiModelProperty(required = true, value = "Password of the user")
	@NotNull

	@Size(min = 1, max = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User status(Status status) {
		this.status = status;
		return this;
	}

	/**
	 * Password of the user
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "Password of the user")

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User profile(Profile profile) {
		this.profile = profile;
		return this;
	}

	/**
	 * Get profile
	 * 
	 * @return profile
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public User addRolesItem(Role rolesItem) {
		if (this.roles == null) {
			this.roles = new HashSet<Role>();
		}
		this.roles.add(rolesItem);
		return this;
	}

	
	
	/**
	 * Get roles
	 * 
	 * @return roles
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User groupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
	
	
	

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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
		User user = (User) o;
		return Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username)
				&& Objects.equals(this.displayName, user.displayName) && Objects.equals(this.password, user.password)
				&& Objects.equals(this.status, user.status) && Objects.equals(this.profile, user.profile)
				&& Objects.equals(this.identities, user.identities)
				&& Objects.equals(this.addresses, user.addresses)
				&& Objects.equals(this.roles, user.roles) && Objects.equals(this.groupId, user.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, displayName, password, status, profile, identities, addresses,
				roles, groupId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class User {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
		sb.append("    identity: ").append(toIndentedString(identities)).append("\n");
		sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
		sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
		sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
		sb.append("}");
		return sb.toString();
	}
	
	public User addIdentitiesItem(Identity identitiesItem) {
		this.identities.add(identitiesItem);
		return this;
	}

	
	/**
	 * @return the identities
	 */
	public Set<Identity> getIdentities() {
		return identities;
	}

	/**
	 * @param identities the identities to set
	 */
	public void setIdentities(Set<Identity> identities) {
		this.identities = identities;
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
