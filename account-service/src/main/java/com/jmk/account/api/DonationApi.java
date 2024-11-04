/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.jmk.account.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jmk.account.model.Donation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")

@Api(value = "donation", description = "the donate API")
@RequestMapping(value = "v1/donations")
public interface DonationApi {

    @ApiOperation(value = "Health check service", nickname = "healthcheck", notes = "Health Check Service")
    @GetMapping(path = "/health")
    public String checkHealth() ;

    @ApiOperation(value = "Save Donation Service", nickname = "saveDonation", notes = "Save Donation Service", response = Donation.class, tags={ "DonationService", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Donation.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    ResponseEntity<Donation> saveDonation(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Donation body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel);

    @ApiOperation(value = "Saving Donations with input arrays Service", nickname = "saveDonations", notes = "Saving Donations", tags={ "DonationService", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(value = "/bulk", produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    ResponseEntity<List<Donation>> saveDonations(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Donation> body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel);
    
    @ApiOperation(value = "Find Donation Details based on the donation id", nickname = "findDonationDetailsById", notes = "Find Donation Details based on the donation id", response = Donation.class, tags={ "DonationService", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully found", response = Donation.class),
        @ApiResponse(code = 400, message = "Invalid Donation name and password supplied"),
        @ApiResponse(code = 404, message = "Donation not found or inactive"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(value = "/{id}")
    ResponseEntity<Donation> findDonationDetailsById(@ApiParam(value = "Donation Id",required=true) @PathVariable("id") Long id);
    
    @ApiOperation(value = "Update Donation Details based on the donation id", nickname = "updateDonationById", notes = "Update Donation Details based on the donation id", response = Donation.class, tags={ "DonationService", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully found", response = Donation.class),
        @ApiResponse(code = 400, message = "Invalid Donation name supplied"),
        @ApiResponse(code = 404, message = "Donation not found or inactive"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @PutMapping(value = "/{id}",
            produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    ResponseEntity<Donation> updateDonation(@ApiParam(value = "Donation Id",required=true) @PathVariable("id") Long id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Donation donation);

    @ApiOperation(value = "Donation Deletion Service based on the donation id", nickname = "deleteDonationById", notes = "Donation Deletion Service based on the donation id", tags={ "DonationService", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Donation deleted succussfully"),
            @ApiResponse(code = 400, message = "Invalid User id supplied"),
            @ApiResponse(code = 404, message = "Donation Id not found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteDonationById(@ApiParam(value = "Donation Id",required=true) @PathVariable("id") Long id);
}
