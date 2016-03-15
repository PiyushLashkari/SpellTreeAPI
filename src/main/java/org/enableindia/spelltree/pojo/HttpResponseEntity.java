package org.enableindia.spelltree.pojo;

/**
 * Represents the HTTPResponse message
 * 
 */
public class HttpResponseEntity {

	private int statusCode;
	private String entity;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

}
