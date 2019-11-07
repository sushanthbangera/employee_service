package com.glarimy.quiz.employee.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	@Id
	@NotNull
	@NotEmpty
	@Size(min = 8, max = 16)
	private String eid;
	@NotNull
	@NotEmpty
	@Size(min = 8, max = 64)
	private String name;
	@Pattern(regexp = "^hr|employee|sme$")
	private String role;
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	private String password;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
