package com.jmk.people.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmk.enums.DocumentType;

import io.swagger.annotations.ApiModelProperty;

/**
 * Identity
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

public class Identity {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("documentType")
	private DocumentType documentType = null;

	@JsonProperty("documentNumber")
	private String documentNumber = null;

	@JsonProperty("documentName")
	private String documentName = null;

	@JsonProperty("documentPath")
	private String documentPath = null;

	@JsonProperty("documentDetails")
	private String documentDetails = null;

	@JsonProperty("groupId")
	private Integer groupId = null;

	@JsonProperty("createdBy")
	private Long createdBy = null;

	@JsonProperty("createdOn")
	private LocalDateTime createdOn = null;

	@JsonProperty("whenModified")
	private LocalDateTime whenModified = null;

	@JsonProperty("version")
	private Long version = null;
	
	@JsonProperty
	@JsonBackReference
	private Person person;

	public Identity id(Long id) {
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

	public Identity documentType(DocumentType documentType) {
		this.documentType = documentType;
		return this;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Password of the user
	 * 
	 * @return documentType
	 **/
	@ApiModelProperty(value = "Password of the user")

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public Identity documentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return documentNumber
	 **/
	@ApiModelProperty(value = "User Type")

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Identity documentName(String documentName) {
		this.documentName = documentName;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return documentName
	 **/
	@ApiModelProperty(value = "User Type")

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Identity documentPath(String documentPath) {
		this.documentPath = documentPath;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return documentPath
	 **/
	@ApiModelProperty(value = "User Type")

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public Identity documentDetails(String documentDetails) {
		this.documentDetails = documentDetails;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return documentDetails
	 **/
	@ApiModelProperty(value = "User Type")

	public String getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(String documentDetails) {
		this.documentDetails = documentDetails;
	}

	public Identity groupId(Integer groupId) {
		this.groupId = groupId;
		return this;
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
		Identity identity = (Identity) o;
		return Objects.equals(this.id, identity.id) && Objects.equals(this.documentType, identity.documentType)
				&& Objects.equals(this.documentNumber, identity.documentNumber)
				&& Objects.equals(this.documentName, identity.documentName)
				&& Objects.equals(this.documentPath, identity.documentPath)
				&& Objects.equals(this.documentDetails, identity.documentDetails)
				&& Objects.equals(this.groupId, identity.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, documentType, documentNumber, documentName, documentPath, documentDetails, groupId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Identity {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    documentType: ").append(toIndentedString(documentType)).append("\n");
		sb.append("    documentNumber: ").append(toIndentedString(documentNumber)).append("\n");
		sb.append("    documentName: ").append(toIndentedString(documentName)).append("\n");
		sb.append("    documentPath: ").append(toIndentedString(documentPath)).append("\n");
		sb.append("    documentDetails: ").append(toIndentedString(documentDetails)).append("\n");
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getWhenModified() {
		return whenModified;
	}

	public void setWhenModified(LocalDateTime whenModified) {
		this.whenModified = whenModified;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
