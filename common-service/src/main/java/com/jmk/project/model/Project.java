package com.jmk.project.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.enums.Status;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project
 */
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Data //It is combination of @ToString, @EqualsAndHashCode ,@Getter,@Setter and @RequiredArgsConstructor
@ApiModel
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	@ApiModelProperty(value="Project Id")
	private Long id = null;

	@ApiModelProperty(required = true, value = "Project name")
	@NotNull
	@Size(min = 1, max = 50)
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
	private LocalDateTime createdOn=null;
	
	@JsonProperty("modifiedBy")
	private Long modifiedBy = null;
	
	@JsonProperty
	private LocalDateTime whenModified=null;
	
	@JsonProperty
	private Long version=null;


}
