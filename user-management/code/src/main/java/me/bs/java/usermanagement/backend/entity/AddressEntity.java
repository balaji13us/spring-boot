package me.bs.java.usermanagement.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ADDRESS")
public class AddressEntity {

	@Id
	@Column(name="ID")
	private Long id;
	private String proxy;
	private boolean primary;
	private String type;
	private String line1;
	private String line2;
	private String line3;
	private String line4;
	private String line5;
	private String city;
	private String state;
	private String zip;
	private String country;
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
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getLine3() {
		return line3;
	}
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	public String getLine4() {
		return line4;
	}
	public void setLine4(String line4) {
		this.line4 = line4;
	}
	public String getLine5() {
		return line5;
	}
	public void setLine5(String line5) {
		this.line5 = line5;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MODEL_NAME=AddressEntity [ id=\"");
		builder.append(id);
		builder.append("\", proxy=\"");
		builder.append(proxy);
		builder.append("\", primary=\"");
		builder.append(primary);
		builder.append("\", type=\"");
		builder.append(type);
		builder.append("\", line1=\"");
		builder.append(line1);
		builder.append("\", line2=\"");
		builder.append(line2);
		builder.append("\", line3=\"");
		builder.append(line3);
		builder.append("\", line4=\"");
		builder.append(line4);
		builder.append("\", line5=\"");
		builder.append(line5);
		builder.append("\", city=\"");
		builder.append(city);
		builder.append("\", state=\"");
		builder.append(state);
		builder.append("\", zip=\"");
		builder.append(zip);
		builder.append("\", country=\"");
		builder.append(country);
		builder.append("\" ]");
		return builder.toString();
	}
	
	
	
}
