package me.bs.java.usermanagement.frontend.rest.handlers;

import java.util.List;

public class ResponseInfo {
	public String code;
	public String description;
	public String status;
	public List<String> errors;

	public ResponseInfo(String status) {
		super();
		this.status = status;
	}
	public ResponseInfo(String code, String description, String status, List<String> errors) {
		super();
		this.code = code;
		this.description = description;
		this.status = status;
		this.errors = errors;
	}
	public ResponseInfo(String code, String description, String status) {
		super();
		this.code = code;
		this.description = description;
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MODEL_NAME=ResponseInfo [ code=\"");
		builder.append(code);
		builder.append("\", description=\"");
		builder.append(description);
		builder.append("\", status=\"");
		builder.append(status);
		builder.append("\", errors=\"");
		builder.append(errors);
		builder.append("\" ]");
		return builder.toString();
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
