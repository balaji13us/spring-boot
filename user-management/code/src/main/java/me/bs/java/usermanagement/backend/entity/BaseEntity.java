package me.bs.java.usermanagement.backend.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class BaseEntity {

	@Id
	@Column(name="ID")
	private Long id;
	private String proxy;
	private boolean primary;
	private String type;
	
}
