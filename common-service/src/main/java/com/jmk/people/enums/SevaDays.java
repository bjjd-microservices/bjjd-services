package com.jmk.people.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SevaDays {

    MONDAY("MONDAY"),
    
    TUESDAY("TUESDAY"),
    
    WEDNESDAY("WEDNESDAY"),
    
    THURSDAY("THURSDAY"),
    
    FRIDAY("FRIDAY"),
    
    SATURDAY("SATURDAY"),
    
    SUNDAY("SUNDAY");

    private String value;

    SevaDays(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SevaDays fromValue(String text) {
      for (SevaDays b : SevaDays.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  
}
