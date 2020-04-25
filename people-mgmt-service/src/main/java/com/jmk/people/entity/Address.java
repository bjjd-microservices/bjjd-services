package com.jmk.people.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.jmk.enums.AddressType;

/**
 * Address
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@Column(name = "house_no")
	private String houseNo = null;

	@Column(name = "address_line1")
	private String addressLine1 = null;

	@Column(name = "address_line2")
	private String addressLine2 = null;

	@Column(name = "city")
	private String city = null;

	@Column(name = "state")
	private String state = null;

	@Column(name = "country")
	private String country = null;

	@Column(name = "pincode")
	private String pinCode = null;

	@Column(name = "landmark")
	private String landmark = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "address_type")
	private AddressType addressType = null;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@Column(name = "groupId")
	private Integer groupId = null;

	@Column(name = "created_by")
	private Long createdBy = null;

	@Column(name = "created_on")
	private Timestamp createdOn = null;

	@Column(name = "when_modified")
	private Timestamp whenModified = null;

	@Version
	private Long version = 1L;

	public Address id(Long id) {
		this.id = id;
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
	 * user id
	 * 
	 * @return id
	 **/
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
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

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/**
	 * @return the addressType
	 */
	public AddressType getAddressType() {
		return addressType;
	}



	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}



	public Address groupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

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
				&& Objects.equals(this.addressType, address.addressType) 
				&& Objects.equals(this.groupId, address.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, houseNo, addressLine1, addressLine2, city, state, country, pinCode, landmark, addressType,
				 groupId);
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

