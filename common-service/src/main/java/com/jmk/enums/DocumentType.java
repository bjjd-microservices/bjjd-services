package com.jmk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {

    PASSPORT("Passport"),
    
    AADHARCARD("AadharCard"),
    
    VOTERID("VoterId"),
    
    PANCARD("PanCard"),
    
    DRIVINGLICENSE("DrivingLicense");

    private String value;

    DocumentType(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DocumentType fromValue(String text) {
      for (DocumentType b : DocumentType.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  
}
