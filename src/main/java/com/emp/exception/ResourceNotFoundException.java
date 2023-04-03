package com.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resource;

	private String resourceName;

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Object getResourceField() {
		return resourceField;
	}

	public void setResourceField(Object resourceField) {
		this.resourceField = resourceField;
	}

	private Object resourceField;

	public ResourceNotFoundException(String resource, String resourceName, Object resourceField) {
		super();
		this.resource = resource;
		this.resourceName = resourceName;
		this.resourceField = resourceField;
	}

}
