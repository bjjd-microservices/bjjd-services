package com.jmk.user.model;

import java.sql.Timestamp;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Address
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-12T22:05:50.743+05:30")

public class Address {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("houseNo")
	private String houseNo = null;

	@JsonProperty("addressLine1")
	private String addressLine1 = null;

	@JsonProperty("addressLine2")
	private String addressLine2 = null;

	@JsonProperty("city")
	private String city = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("pinCode")
	private String pinCode = null;

	@JsonProperty("landmark")
	private String landmark = null;

	@JsonProperty("type")
	private String type = null;

	@JsonProperty("addressType")
	private String addressType = null;

	@JsonProperty("groupId")
	private Integer groupId = null;

	@JsonProperty("createdBy")
	private Integer createdBy = null;

	@JsonProperty("createdOn")
	private Timestamp createdOn = null;

	@JsonProperty("whenModified")
	private Timestamp whenModified = null;

	@JsonProperty("version")
	private Long version = null;

	@JsonIgnore
	private User user;

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

	public Address houseNo(String houseNo) {
		this.houseNo = houseNo;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return houseNo
	 **/
	@ApiModelProperty(value = "User Type")
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public Address addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the whenModified
	 */
	public Timestamp getWhenModified() {
		return whenModified;
	}

	/**
	 * @param whenModified the whenModified to set
	 */
	public void setWhenModified(Timestamp whenModified) {
		this.whenModified = whenModified;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * User Type
	 * 
	 * @return addressLine1
	 **/
	@ApiModelProperty(value = "User Type")

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public Address addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return addressLine2
	 **/
	@ApiModelProperty(value = "User Type")

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Address city(String city) {
		this.city = city;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return city
	 **/
	@ApiModelProperty(value = "User Type")

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address state(String state) {
		this.state = state;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return state
	 **/
	@ApiModelProperty(value = "User Type")

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return country
	 **/
	@ApiModelProperty(value = "User Type")

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address pinCode(String pinCode) {
		this.pinCode = pinCode;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return pinCode
	 **/
	@ApiModelProperty(value = "User Type")

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Address landmark(String landmark) {
		this.landmark = landmark;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return landmark
	 **/
	@ApiModelProperty(value = "User Type")

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Address type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "User Type")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Address addressType(String addressType) {
		this.addressType = addressType;
		return this;
	}

	/**
	 * User Type
	 * 
	 * @return addressType
	 **/
	@ApiModelProperty(value = "User Type")

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Address groupId(Integer groupId) {
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
		Address address = (Address) o;
		return Objects.equals(this.id, address.id) && Objects.equals(this.houseNo, address.houseNo)
				&& Objects.equals(this.addressLine1, address.addressLine1)
				&& Objects.equals(this.addressLine2, address.addressLine2) && Objects.equals(this.city, address.city)
				&& Objects.equals(this.state, address.state) && Objects.equals(this.country, address.country)
				&& Objects.equals(this.pinCode, address.pinCode) && Objects.equals(this.landmark, address.landmark)
				&& Objects.equals(this.type, address.type) && Objects.equals(this.addressType, address.addressType)
				&& Objects.equals(this.groupId, address.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, houseNo, addressLine1, addressLine2, city, state, country, pinCode, landmark, type,
				addressType, groupId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Address {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    houseNo: ").append(toIndentedString(houseNo)).append("\n");
		sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
		sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    pinCode: ").append(toIndentedString(pinCode)).append("\n");
		sb.append("    landmark: ").append(toIndentedString(landmark)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    addressType: ").append(toIndentedString(addressType)).append("\n");
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
