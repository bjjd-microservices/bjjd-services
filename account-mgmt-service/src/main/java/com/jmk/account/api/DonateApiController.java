package com.jmk.account.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.account.model.Donation;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")

@RestController
public class DonateApiController implements DonateApi {

    private static final Logger log = LoggerFactory.getLogger(DonateApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DonateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Donation> saveDonation(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Donation body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Donation>(objectMapper.readValue("{  \"receivedBy\" : 5,  \"amount\" : 6027456183070.4013671875,  \"donorType\" : \"MEMBER\",  \"donorMobileNo\" : \"donorMobileNo\",  \"donorPANNo\" : \"donorPANNo\",  \"groupId\" : 5,  \"description\" : \"description\",  \"donorCity\" : \"donorCity\",  \"reference\" : \"reference\",  \"donorName\" : \"donorName\",  \"donationDate\" : \"2000-01-23\",  \"donorId\" : \"donorId\",  \"id\" : 0,  \"projectName\" : \"projectName\",  \"projectId\" : 1,  \"remarks\" : \"remarks\",  \"status\" : \"A\"}", Donation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Donation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Donation>(objectMapper.readValue("<null>  <id>123456789</id>  <donationDate>2000-01-23</donationDate>  <amount>1.3579</amount>  <projectId>123</projectId>  <projectName>aeiou</projectName>  <donorType>aeiou</donorType>  <donorId>aeiou</donorId>  <donorName>aeiou</donorName>  <donorCity>aeiou</donorCity>  <donorMobileNo>aeiou</donorMobileNo>  <donorPANNo>aeiou</donorPANNo>  <reference>aeiou</reference>  <receivedBy>123456789</receivedBy>  <description>aeiou</description>  <remarks>aeiou</remarks>  <status>aeiou</status>  <groupId>123</groupId></null>", Donation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Donation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Donation>(HttpStatus.NOT_IMPLEMENTED);
    }

}
