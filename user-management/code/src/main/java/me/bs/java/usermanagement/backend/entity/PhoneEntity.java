package me.bs.java.usermanagement.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="PHONE")
public class PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String proxy;
	private boolean isPrimary;
	private String type;
	private String number;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="user_id")
	private UserEntity user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PhoneEntity(String proxy, boolean isPrimary, String type, String number, UserEntity user) {
		super();
		this.proxy = proxy;
		this.isPrimary = isPrimary;
		this.type = type;
		this.number = number;
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MODEL_NAME=PhoneEntity [ id=\"");
		builder.append(id);
		builder.append("\", proxy=\"");
		builder.append(proxy);
		builder.append("\", isPrimary=\"");
		builder.append(isPrimary);
		builder.append("\", type=\"");
		builder.append(type);
		builder.append("\", number=\"");
		builder.append(number);
		builder.append("\", user=\"");
		builder.append(user);
		builder.append("\" ]");
		return builder.toString();
	}

	public PhoneEntity() {
		super();
	}
	 

		
}
