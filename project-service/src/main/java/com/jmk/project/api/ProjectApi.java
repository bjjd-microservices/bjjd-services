/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.jmk.project.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jmk.project.model.Project;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-06T22:35:14.568+05:30")

@Api(value = "project", description = "the project API")
@RequestMapping(value = "/project")
public interface ProjectApi {

    @GetMapping(path = "/")
    public String appUpAndRunning() ;

    @ApiOperation(value = "Project Creation Service", nickname = "createProject", notes = "Project Creation Service", response = Project.class, tags={ "ProjectMgmt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Project.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Project> createProject(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Project body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel);


    @ApiOperation(value = "Project Creation with input arrays Service", nickname = "createProjects", notes = "Project Finding Service", tags={ "ProjectMgmt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/createProjects",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<List<Project>> createProjects(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Project> body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel);

    @ApiOperation(value = "Project Deletion Service based on the project id", nickname = "deleteProjectById", notes = "Project Deletion Service based on the project id", tags={ "ProjectMgmt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Project deleted succussfully"),
        @ApiResponse(code = 400, message = "Invalid User id supplied"),
        @ApiResponse(code = 404, message = "Project Id not found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProjectById(@ApiParam(value = "Project Id",required=true) @PathVariable("id") Long id);
    
    @ApiOperation(value = "Project Deletion Service based on the project code", nickname = "deleteProjectByProjectCode", notes = "Project Deletion Service based on the project code", tags={ "ProjectMgmt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Project deleted succussfully"),
        @ApiResponse(code = 400, message = "Invalid project code supplied"),
        @ApiResponse(code = 404, message = "Project code not found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/deleteByProjectCode", produces = { "application/json" }, consumes = {
	"application/json" }, method = RequestMethod.DELETE)
    ResponseEntity<Integer> deleteProjectByProjectCode(@ApiParam(value = "Project Id",required=true) @PathVariable("projectCode") String projectCode);

    @ApiOperation(value = "Find Project Details based on the project id", nickname = "findProjectDetailsById", notes = "Find Project Details based on the project id", response = Project.class, tags={ "ProjectMgmt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully found", response = Project.class),
        @ApiResponse(code = 400, message = "Invalid Project name and password supplied"),
        @ApiResponse(code = 404, message = "Project not found or inactive"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    ResponseEntity<Project> findProjectDetailsById(@ApiParam(value = "Project Id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "Find all the projects by status", nickname = "findProjectsByStatus", notes = "Find all the projects by status", response = Project.class, responseContainer = "List", tags={ "ProjectMgmt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Project.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(value = "/findByStatus",
        produces = { "application/json", "application/xml" })
    ResponseEntity<List<Project>> findProjectsByStatus(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "The status to restrict the results to.  If not provided, all records are returned", allowableValues = "A, I") @Valid @RequestParam(value = "status", required = false) String status);

    @ApiOperation(value = "Find the project by code", nickname = "findProjectByCode", notes = "Find the project by code", response = Project.class, tags={ "ProjectMgmt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Project.class),
        @ApiResponse(code = 400, message = "Invalid Project Code"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/findProjectByCode",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<Project> findProjectByCode(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "") @Valid @RequestParam(value = "code", required = false) String code);

    @ApiOperation(value = "Update Project Details based on the project id", nickname = "updateProjectById", notes = "Update Project Details based on the project id", response = Project.class, tags={ "ProjectMgmt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully found", response = Project.class),
        @ApiResponse(code = 400, message = "Invalid Project name supplied"),
        @ApiResponse(code = 404, message = "Project not found or inactive"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Project> updateProjectById(@ApiParam(value = "Project Id",required=true) @PathVariable("id") Long id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Project body);

}
