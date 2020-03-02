package com.jmk.people.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.jmk.people.model.Person;

import io.swagger.annotations.ApiModelProperty;

/**
 * Devotee
 */
@Entity
@Table(name = "DEVOTEE")
public class Devotee extends Person {

	@Enumerated(EnumType.STRING)
	@Column(name = "devotee_type")
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
