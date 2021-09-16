package com.jmk.people.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.jmk.people.enums.SevaDays;
import com.jmk.people.enums.SevadarCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sevadar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SEVADAR")
@DiscriminatorValue("Sevadar")
@PrimaryKeyJoinColumn(name="ID",referencedColumnName="ID")
public class Sevadar extends Person  {

  @Enumerated(EnumType.STRING)
  @Column(name="sevadar_category")
  private SevadarCategory sevadarCategory = null;

  @ElementCollection(fetch=FetchType.EAGER)
  @CollectionTable(name = "sevadar_sevadays", joinColumns = @JoinColumn(name = "sevadar_id"))
  @Enumerated(EnumType.STRING)
  @Column(name="seva_days")
  private Collection<SevaDays> sevaDays = null;

  @Column(name="joining_date")
  private LocalDate joiningDate = null;

  public Sevadar sevadarCategory(SevadarCategory sevadarCategory) {
    this.sevadarCategory = sevadarCategory;
    return this;
  }

}

