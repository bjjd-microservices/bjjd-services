package com.jmk.messaging.model;

import java.time.LocalDateTime;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
public class Message {
	
	@JsonProperty("id")
	private Long id=null;
	
	@JsonProperty("fromMobileNo")
	private String fromMobileNo;
	
	@JsonProperty("body")
	private String body;
	
	@JsonProperty("toMobileNo")
	private String toMobileNo;
	
	@JsonProperty("communicationMedium")
	private String communicationMedium;
	
	@JsonProperty("sentTime")
	private LocalDateTime sentTime;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fromMobileNo
	 */
	public String getFromMobileNo() {
		return fromMobileNo;
	}

	/**
	 * @param fromMobileNo the fromMobileNo to set
	 */
	public void setFromMobileNo(String fromMobileNo) {
		this.fromMobileNo = fromMobileNo;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the toMobileNo
	 */
	public String getToMobileNo() {
		return toMobileNo;
	}

	/**
	 * @param toMobileNo the toMobileNo to set
	 */
	public void setToMobileNo(String toMobileNo) {
		this.toMobileNo = toMobileNo;
	}

	/**
	 * @return the communicationMedium
	 */
	public String getCommunicationMedium() {
		return communicationMedium;
	}

	/**
	 * @param communicationMedium the communicationMedium to set
	 */
	public void setCommunicationMedium(String communicationMedium) {
		this.communicationMedium = communicationMedium;
	}

	/**
	 * @return the sentTime
	 */
	public LocalDateTime getSentTime() {
		return sentTime;
	}

	/**
	 * @param sentTime the sentTime to set
	 */
	public void setSentTime(LocalDateTime sentTime) {
		this.sentTime = sentTime;
	}
	
}
