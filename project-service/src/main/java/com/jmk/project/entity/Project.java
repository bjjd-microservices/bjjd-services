package com.jmk.project.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROJECT")
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name = null;
	
	@Column(name="code",unique=true)
	private String code=null;


	@Column(name = "description")
	private String description = null;

	@Column(name = "manager")
	private String manager = null;

	@Column(name = "start_date")
	private LocalDate startDate = null;

	@Column(name = "completion_date")
	private LocalDate completionDate = null;

	@Column(name = "photo_id")
	private String photoId = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status = null;

	@Column(name = "groupId")
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
	private Long version=null;

}
