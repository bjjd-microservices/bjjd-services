package com.jmk.account.enums;

public enum PaymentMode {

	CASH("CASH"), CHEQUE("CHEQUE"), ONLINE("ONLINE");
	private String value;

	private PaymentMode(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	

}
