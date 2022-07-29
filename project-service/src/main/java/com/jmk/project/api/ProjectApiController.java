package com.jmk.project.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.enums.Status;
import com.jmk.project.feign.client.UserServiceClient;
import com.jmk.project.model.Project;
import com.jmk.project.service.ProjectService;
import com.jmk.user.model.User;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-06T22:35:14.568+05:30")
@RestController
public class ProjectApiController implements ProjectApi {

	private static final Logger log = LoggerFactory.getLogger(ProjectApiController.class);
	private final HttpServletRequest request;

	@Autowired
	private UserServiceClient userServiceClient;

	@Autowired
	private ProjectService projectService;

	@org.springframework.beans.factory.annotation.Autowired
	public ProjectApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.request = request;
	}

	public ResponseEntity<Project> createProject(
			@ApiParam(value = "", required = true) @Valid @RequestBody Project project,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				User user = userServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(project, user);
			}
			project = projectService.saveProject(project);
			return new ResponseEntity<Project>(project, HttpStatus.OK);
		}
		return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Project> findProjectDetailsById(
			@ApiParam(value = "Project Id", required = true) @PathVariable("id") Long id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			Project project = projectService.findProjectDetailsById(id);
			return new ResponseEntity<Project>(project, HttpStatus.OK);
		}
		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<Project> findProjectByCode(
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel,
			@ApiParam(value = "") @Valid @RequestParam(value = "code", required = false) String code) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			Project project = projectService.findProjectByCode(code);
			return new ResponseEntity<Project>(project, HttpStatus.OK);
		}
		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Project>> findProjectsByStatus(
			@ApiParam(value = "xChannel") @RequestHeader(value = "xChannel", required = false) String xChannel,
			@ApiParam(value = "The status to restrict the results to.  If not provided, all records are returned", allowableValues = "A, I") @Valid @RequestParam(value = "status", required = false) String status) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			List<Project> projects = projectService.findAllProjectsByStatus(Status.A);
			return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
		}

		return new ResponseEntity<List<Project>>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<List<Project>> createProjects(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<Project> projects,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")) {
			if (StringUtils.isNotBlank(username)) {
				User user = userServiceClient.findUserDetailsByUserName(username).getBody();
				projects = projects.stream().map(project -> enrichCommonDetails(project, user))
						.collect(Collectors.toList());
			}
			projects = projectService.saveProjects(projects);
			if (projects != null) {
				return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
			}
		}

		return new ResponseEntity<List<Project>>(HttpStatus.NOT_IMPLEMENTED);
	}


	public ResponseEntity<Project> updateProjectById(
			@ApiParam(value = "Project Id", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "", required = true) @Valid @RequestBody Project project) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				User user = userServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(project, user);
			}
			project = projectService.saveProject(project);
			return new ResponseEntity<Project>(project, HttpStatus.OK);
		}

		return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<Void> deleteProjectById(
			@ApiParam(value = "Project Id", required = true) @PathVariable("id") Long id) {
		projectService.deleteProjectById(id);
		// Below return statement is the correct way to handle the delete request
		return ResponseEntity.noContent().build();
	}


	private Project enrichCommonDetails(Project project, User user) {
		if (project.getId() == null) {
			project.setCreatedOn(LocalDateTime.now());
			project.setCreatedBy(user.getId());
			project.setGroupId(user.getGroupId());
		}
		project.setWhenModified(LocalDateTime.now());
		project.setModifiedBy(user.getId());
		return project;
	}

	@Override
	public ResponseEntity<Integer> deleteProjectByProjectCode(@ApiParam(value = "projectCode") @Valid @RequestParam(value = "projectCode", required = true) String projectCode) {
		Integer deleteRecords=projectService.deleteProjectByProjectCode(projectCode);
		return new ResponseEntity<Integer>(deleteRecords,HttpStatus.OK);
	}

}
