package com.jmk.project.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModelProperty;

/**
 * Project
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-06T22:35:14.568+05:30")
public class Project {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("name")
	private String name = null;
	
	@JsonProperty("code")
	private String code=null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("manager")
	private String manager = null;

	@JsonProperty("start_date")
	private LocalDate startDate = null;

	@JsonProperty("completion_date")
	private LocalDate completionDate = null;

	@JsonProperty("photoId")
	private String photoId = null;

	@JsonProperty("status")
	private Status status = null;

	@JsonProperty("groupId")
	private Integer groupId = null;
	
	@JsonProperty
	private Long createdBy = null;
	
	@JsonProperty
	private Timestamp createdOn=null;
	
	@JsonProperty
	private Timestamp whenModified=null;
	
	@JsonProperty
	private Long version=null;


	public Project id(Long id) {
		this.id = id;
		return this;
	}

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
	
	

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getWhenModified() {
		return whenModified;
	}

	public void setWhenModified(Timestamp whenModified) {
		this.whenModified = whenModified;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * User name
	 * 
	 * @return projectName
	 **/
	@ApiModelProperty(required = true, value = "User name")
	@NotNull
	@Size(min = 1, max = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		Project project = (Project) o;
		return Objects.equals(this.id, project.id) && Objects.equals(this.name, project.name)
				&& Objects.equals(this.description, project.description)
				&& Objects.equals(this.manager, project.manager) && Objects.equals(this.startDate, project.startDate)
				&& Objects.equals(this.completionDate, project.completionDate)
				&& Objects.equals(this.photoId, project.photoId) && Objects.equals(this.status, project.status)
				&& Objects.equals(this.groupId, project.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, manager, startDate, completionDate, photoId, status, groupId);
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Project {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    projectName: ").append(toIndentedString(name)).append("\n");
		sb.append("    displayName: ").append(toIndentedString(description)).append("\n");
		sb.append("    projectManager: ").append(toIndentedString(manager)).append("\n");
		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
		sb.append("    photoId: ").append(toIndentedString(photoId)).append("\n");
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
