package com.jmk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageStatus {
	SENT("Sent"), WAITING_FOR_RECEIPT("WaitingForReceipt");

	private String value;

	private MessageStatus(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static MessageStatus fromValue(String text) {
		for (MessageStatus b : MessageStatus.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
