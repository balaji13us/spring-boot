package me.bs.java.usermanagement.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="PHONE")
public class PhoneEntity {

	@Id
	@Column(name="ID")
	private Long id;
	private String proxy;
	private boolean primary;
	private String type;
	private String number;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProxy() {
		return proxy;
	}
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MODEL_NAME=PhoneEntity [ id=\"");
		builder.append(id);
		builder.append("\", proxy=\"");
		builder.append(proxy);
		builder.append("\", primary=\"");
		builder.append(primary);
		builder.append("\", type=\"");
		builder.append(type);
		builder.append("\", number=\"");
		builder.append(number);
		builder.append("\" ]");
		return builder.toString();
	}
	
}
