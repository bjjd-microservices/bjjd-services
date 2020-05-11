package com.jmk.darshan.api;

import com.jmk.darshan.model.Darshan;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-12T00:51:00.325+05:30")

@Controller
public class DarshanApiController implements DarshanApi {

    private static final Logger log = LoggerFactory.getLogger(DarshanApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DarshanApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteDarshanById(@ApiParam(value = "Darshan Id",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Darshan> findDarshanDetailsById(@ApiParam(value = "Darshan Id",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Darshan>(objectMapper.readValue("{  \"totalVisitors\" : 5,  \"totalKids\" : 5,  \"totalMen\" : 6,  \"visitorType\" : \"MEMBER\",  \"groupId\" : 2,  \"visitorState\" : \"visitorState\",  \"reference\" : \"reference\",  \"visitorName\" : \"visitorName\",  \"visitingDate\" : \"2000-01-23\",  \"visitorMobileNo\" : \"visitorMobileNo\",  \"id\" : 0,  \"totalWomen\" : 1,  \"visitorId\" : \"visitorId\",  \"visitorCity\" : \"visitorCity\"}", Darshan.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Darshan>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Darshan>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Darshan> saveDarshan(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Darshan body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Darshan>(objectMapper.readValue("{  \"totalVisitors\" : 5,  \"totalKids\" : 5,  \"totalMen\" : 6,  \"visitorType\" : \"MEMBER\",  \"groupId\" : 2,  \"visitorState\" : \"visitorState\",  \"reference\" : \"reference\",  \"visitorName\" : \"visitorName\",  \"visitingDate\" : \"2000-01-23\",  \"visitorMobileNo\" : \"visitorMobileNo\",  \"id\" : 0,  \"totalWomen\" : 1,  \"visitorId\" : \"visitorId\",  \"visitorCity\" : \"visitorCity\"}", Darshan.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Darshan>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Darshan>(objectMapper.readValue("<null>  <id>123456789</id>  <visitingDate>2000-01-23</visitingDate>  <visitorType>aeiou</visitorType>  <visitorId>aeiou</visitorId>  <visitorName>aeiou</visitorName>  <visitorCity>aeiou</visitorCity>  <visitorState>aeiou</visitorState>  <visitorMobileNo>aeiou</visitorMobileNo>  <reference>aeiou</reference>  <totalMen>123</totalMen>  <totalWomen>123</totalWomen>  <totalKids>123</totalKids>  <totalVisitors>123</totalVisitors>  <groupId>123</groupId></null>", Darshan.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Darshan>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Darshan>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> saveDarshansWithArrayInput(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Darshan> body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Darshan> updateDarshanById(@ApiParam(value = "Darshan Id",required=true) @PathVariable("id") Integer id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Darshan body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Darshan>(objectMapper.readValue("{  \"totalVisitors\" : 5,  \"totalKids\" : 5,  \"totalMen\" : 6,  \"visitorType\" : \"MEMBER\",  \"groupId\" : 2,  \"visitorState\" : \"visitorState\",  \"reference\" : \"reference\",  \"visitorName\" : \"visitorName\",  \"visitingDate\" : \"2000-01-23\",  \"visitorMobileNo\" : \"visitorMobileNo\",  \"id\" : 0,  \"totalWomen\" : 1,  \"visitorId\" : \"visitorId\",  \"visitorCity\" : \"visitorCity\"}", Darshan.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Darshan>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Darshan>(HttpStatus.NOT_IMPLEMENTED);
    }

}
