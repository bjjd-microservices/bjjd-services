package com.jmk.project.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.project.model.Project;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-06T22:35:14.568+05:30")

@RestController
public class ProjectApiController implements ProjectApi {

    private static final Logger log = LoggerFactory.getLogger(ProjectApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProjectApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Project> createProject(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Project body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Project>(objectMapper.readValue("{  \"projectManager\" : \"projectManager\",  \"displayName\" : \"displayName\",  \"groupId\" : 6,  \"photoId\" : \"photoId\",  \"completionDate\" : \"2000-01-23\",  \"id\" : 0,  \"projectName\" : \"projectName\",  \"startDate\" : \"2000-01-23\",  \"status\" : \"A\"}", Project.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Project>(objectMapper.readValue("<null>  <id>123456789</id>  <projectName>aeiou</projectName>  <displayName>aeiou</displayName>  <projectManager>aeiou</projectManager>  <startDate>2000-01-23</startDate>  <completionDate>2000-01-23</completionDate>  <photoId>aeiou</photoId>  <status>aeiou</status>  <groupId>123</groupId></null>", Project.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createProjectsWithArrayInput(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Project> body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteProjectById(@ApiParam(value = "Project Id",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Project> findProjectDetailsById(@ApiParam(value = "Project Id",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Project>(objectMapper.readValue("{  \"projectManager\" : \"projectManager\",  \"displayName\" : \"displayName\",  \"groupId\" : 6,  \"photoId\" : \"photoId\",  \"completionDate\" : \"2000-01-23\",  \"id\" : 0,  \"projectName\" : \"projectName\",  \"startDate\" : \"2000-01-23\",  \"status\" : \"A\"}", Project.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Project>> findProjectsByStatus(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "The status to restrict the results to.  If not provided, all records are returned", allowableValues = "A, I") @Valid @RequestParam(value = "status", required = false) String status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Project>>(objectMapper.readValue("[ {  \"projectManager\" : \"projectManager\",  \"displayName\" : \"displayName\",  \"groupId\" : 6,  \"photoId\" : \"photoId\",  \"completionDate\" : \"2000-01-23\",  \"id\" : 0,  \"projectName\" : \"projectName\",  \"startDate\" : \"2000-01-23\",  \"status\" : \"A\"}, {  \"projectManager\" : \"projectManager\",  \"displayName\" : \"displayName\",  \"groupId\" : 6,  \"photoId\" : \"photoId\",  \"completionDate\" : \"2000-01-23\",  \"id\" : 0,  \"projectName\" : \"projectName\",  \"startDate\" : \"2000-01-23\",  \"status\" : \"A\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Project>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<List<Project>>(objectMapper.readValue("<null>  <id>123456789</id>  <projectName>aeiou</projectName>  <displayName>aeiou</displayName>  <projectManager>aeiou</projectManager>  <startDate>2000-01-23</startDate>  <completionDate>2000-01-23</completionDate>  <photoId>aeiou</photoId>  <status>aeiou</status>  <groupId>123</groupId></null>", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<List<Project>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Project>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Project> updateProjectById(@ApiParam(value = "Project Id",required=true) @PathVariable("id") Integer id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Project body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Project>(objectMapper.readValue("{  \"projectManager\" : \"projectManager\",  \"displayName\" : \"displayName\",  \"groupId\" : 6,  \"photoId\" : \"photoId\",  \"completionDate\" : \"2000-01-23\",  \"id\" : 0,  \"projectName\" : \"projectName\",  \"startDate\" : \"2000-01-23\",  \"status\" : \"A\"}", Project.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
    }

}
