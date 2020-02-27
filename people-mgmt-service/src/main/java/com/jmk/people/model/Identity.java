package com.jmk.people.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Identity
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

public class Identity   {
  @JsonProperty("id")
  private Long id = null;

  /**
   * Password of the user
   */
  public enum DocumentTypeEnum {
    PASSPORT("Passport"),
    
    AADHARCARD("AadharCard"),
    
    VOTERID("VoterId"),
    
    PANCARD("PanCard"),
    
    DRIVINGLICENSE("DrivingLicense");

    private String value;

    DocumentTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DocumentTypeEnum fromValue(String text) {
      for (DocumentTypeEnum b : DocumentTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("documentType")
  private DocumentTypeEnum documentType = null;

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

  public Identity id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * user id
   * @return id
  **/
  @ApiModelProperty(value = "user id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Identity documentType(DocumentTypeEnum documentType) {
    this.documentType = documentType;
    return this;
  }

  /**
   * Password of the user
   * @return documentType
  **/
  @ApiModelProperty(value = "Password of the user")


  public DocumentTypeEnum getDocumentType() {
    return documentType;
  }

  public void setDocumentType(DocumentTypeEnum documentType) {
    this.documentType = documentType;
  }

  public Identity documentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  /**
   * User Type
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
    return Objects.equals(this.id, identity.id) &&
        Objects.equals(this.documentType, identity.documentType) &&
        Objects.equals(this.documentNumber, identity.documentNumber) &&
        Objects.equals(this.documentName, identity.documentName) &&
        Objects.equals(this.documentPath, identity.documentPath) &&
        Objects.equals(this.documentDetails, identity.documentDetails) &&
        Objects.equals(this.groupId, identity.groupId);
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
}

