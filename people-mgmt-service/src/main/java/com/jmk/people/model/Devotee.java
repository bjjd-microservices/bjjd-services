package com.jmk.people.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Devotee
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")
public class Devotee extends Person {
	@JsonProperty("devoteeType")
	private String devoteeType = null;

	public Devotee devoteeType(String devoteeType) {
		this.devoteeType = devoteeType;
		return this;
	}

	/**
	 * devotee id
	 * 
	 * @return devoteeType
	 **/
	@ApiModelProperty(value = "devotee id")

	public String getDevoteeType() {
		return devoteeType;
	}

	public void setDevoteeType(String devoteeType) {
		this.devoteeType = devoteeType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Devotee devotee = (Devotee) o;
		return Objects.equals(this.devoteeType, devotee.devoteeType) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(devoteeType, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Devotee {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    devoteeType: ").append(toIndentedString(devoteeType)).append("\n");
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
