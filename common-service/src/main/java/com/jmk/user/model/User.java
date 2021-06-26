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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data //It is combination of @ToString, @EqualsAndHashCode ,@Getter,@Setter and @RequiredArgsConstructor
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

}
