package me.bs.java.usermanagement.backend.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="USER")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String proxy;
	private String title;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	
	@OneToMany(mappedBy = "user")
	 @JsonManagedReference
	private List<AddressEntity> addresses;
	
	@OneToMany(mappedBy = "user")
	 @JsonManagedReference
	private List<PhoneEntity> phoneNumbers;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	public List<PhoneEntity> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneEntity> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public UserEntity( String proxy, String title, String firstName, String lastName, String fullName,
			String email, List<AddressEntity> addresses, List<PhoneEntity> phoneNumbers) {
		super();
		this.proxy = proxy;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.email = email;
		this.addresses = addresses;
		this.phoneNumbers = phoneNumbers;
	}

	public UserEntity() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MODEL_NAME=UserEntity [ id=\"");
		builder.append(id);
		builder.append("\", proxy=\"");
		builder.append(proxy);
		builder.append("\", title=\"");
		builder.append(title);
		builder.append("\", firstName=\"");
		builder.append(firstName);
		builder.append("\", lastName=\"");
		builder.append(lastName);
		builder.append("\", fullName=\"");
		builder.append(fullName);
		builder.append("\", email=\"");
		builder.append(email);
		builder.append("\", addresses=\"");
		builder.append(addresses);
		builder.append("\", phoneNumbers=\"");
		builder.append(phoneNumbers);
		builder.append("\" ]");
		return builder.toString();
	}
	

	
		
}
