package com.jmk.people.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.jmk.people.enums.MemberType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Member
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEMBER")
@DiscriminatorValue("Member")
@PrimaryKeyJoinColumn(name="ID",referencedColumnName="ID")
public class Member extends Person  {

  @Enumerated(EnumType.STRING)
  @Column(name = "member_type")
  private MemberType memberType = null;

  @Column(name="joining_date")
  private LocalDate joiningDate = null;

  @Column(name="validity")
  private LocalDate validity = null;

}

