package com.jmk.darshan.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Password of the user
 */
public enum VisitorType {
  MEMBER("MEMBER"),
  
  SEVADAR("SEVADAR,"),
  
  DEVOTEE("DEVOTEE");

  private String value;

  VisitorType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static VisitorType fromValue(String text) {
    for (VisitorType b : VisitorType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

