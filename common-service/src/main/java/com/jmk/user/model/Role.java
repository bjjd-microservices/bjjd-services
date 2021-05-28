package com.jmk.user.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModelProperty;

/**
 * Role
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-12T22:05:50.743+05:30")

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name = null;

	private String description;

	@JsonProperty("status")
	private Status status = null;

	@JsonProperty
	@JsonBackReference
	private Set<User> users=new HashSet<>();

	private List<Module> modules = null;

	@JsonProperty("groupId")
	private Integer groupId = null;

	@JsonProperty("createdBy")
	private Long createdBy = null;

	@JsonProperty("createdOn")
	private LocalDateTime createdOn = null;
	
	@JsonProperty("modifiedBy")
	private Long modifiedBy = null;

	@JsonProperty("whenModified")
	private LocalDateTime whenModified = null;

	@JsonProperty("version")
	private Long version = null;

	/**
	 * user id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "role id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/**
	 * @return the modules
	 */
	public List<Module> getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(List<Module> modules) {
		this.modules = modules;
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
	 * @return the modifiedBy
	 */
	public Long getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
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

	public Role name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "User Type")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Password of the user
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "Password of the user")

	public Role groupId(Integer groupId) {
		this.groupId = groupId;
		return this;
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
		Role role = (Role) o;
		return Objects.equals(this.id, role.id) && Objects.equals(this.name, role.name)
				&& Objects.equals(this.status, role.status) && Objects.equals(this.groupId, role.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, status, groupId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Role {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
		sb.append("}");
		return sb.toString();
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
