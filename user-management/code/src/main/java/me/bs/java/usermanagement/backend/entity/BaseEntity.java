package me.bs.java.usermanagement.backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class BaseEntity {

	@Id
	@Column(name="ID")
	private Long id;
	private String proxy;
	private String createdBy;
	private String updateBy;
	private Date createdDate;
	private Date updatedDated;
	
}
