package com.jmk.people.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MemberType {

    LIFETIME("Lifetime"),
    
    ONEYEAR("OneYear"),
    
    THREEYEAR("ThreeYear"),
    
    FIVEYEAR("FiveYear");

    private String value;

    MemberType(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MemberType fromValue(String text) {
      for (MemberType b : MemberType.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  
}
