package com.staterkit.domain;

/**
 * File : Status.java 
 * Description : POJO Class which holds the send mail reponse.
 *  Revision History :	Version	Date		 Author	Reason
 *   						0.1 01-Sep-2016	 Alex  Initial version
 */
public class Status {

	private String message;
	private boolean isError;

	public Status() {
		isError = false;
		this.message = "";
	}

	public Status(boolean isError, String message) {
		this.isError = isError;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean error) {
		this.isError = error;
	}
}