package com.jmk.people.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Devotee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEVOTEE")
@DiscriminatorValue("Devotee")
@PrimaryKeyJoinColumn(name="ID",referencedColumnName="ID")
public class Devotee extends Person {

	@Column(name = "devotee_type")
	private String devoteeType = null;

}

