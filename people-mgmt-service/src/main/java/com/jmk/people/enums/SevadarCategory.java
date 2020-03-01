package com.jmk.people.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SevadarCategory {

    AANRTIK("Aanrtik"),
    
    BAHARI("Bahari"),
    
    RATRI("Ratri");

    private String value;

    SevadarCategory(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SevadarCategory fromValue(String text) {
      for (SevadarCategory b : SevadarCategory.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  
}
