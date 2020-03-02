package com.jmk.people.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.enums.DocumentType;

/**
 * Identity
 */
@Entity
@Table(name = "USER")
public class Identity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "document_type")
	private DocumentType documentType = null;

	@Column(name = "document_number")
	private String documentNumber = null;

	@Column(name = "document_name")
	private String documentName = null;

	@Column(name = "document_path")
	private String documentPath = null;

	@Column(name = "document_details")
	private String documentDetails = null;

	@Column(name = "group_id")
	private Integer groupId = null;

	@Column(name = "created_by")
	private Integer createdBy = null;

	@Column(name = "created_on")
	private Timestamp createdOn = null;

	@Column(name = "when_modified")
	private Timestamp whenModified = null;

	@Version
	@Column(name = "VERSION", nullable = false, columnDefinition = "default 1")
	private Long version = 1L;

	public Identity id(Long id) {
		this.id = id;
		return this;
	}

	
	
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
	 * @return the documentType
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}



	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}



	/**
	 * @return the documentNumber
	 */
	public String getDocumentNumber() {
		return documentNumber;
	}



	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}



	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}



	/**
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}



	/**
	 * @return the documentPath
	 */
	public String getDocumentPath() {
		return documentPath;
	}



	/**
	 * @param documentPath the documentPath to set
	 */
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}



	/**
	 * @return the documentDetails
	 */
	public String getDocumentDetails() {
		return documentDetails;
	}



	/**
	 * @param documentDetails the documentDetails to set
	 */
	public void setDocumentDetails(String documentDetails) {
		this.documentDetails = documentDetails;
	}



	/**
	 * @return the groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}



	/**
	 * @param groupId the groupId to set
	 */
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getWhenModified() {
		return whenModified;
	}

	public void setWhenModified(Timestamp whenModified) {
		this.whenModified = whenModified;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
