package com.jmk.account.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Password of the user
 */
public enum DonorType {
  MEMBER("MEMBER"),
  
  SEVADAR_("SEVADAR,"),
  
  DEVOTEE("DEVOTEE");

  private String value;

  DonorType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DonorType fromValue(String text) {
    for (DonorType b : DonorType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

