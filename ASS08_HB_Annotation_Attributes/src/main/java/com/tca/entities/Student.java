package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tca_student")
public class Student {

	@Id
	@Column(name = "tca_rno")
	private Integer rno;

	@Column(name = "tca_name",length=50, nullable = false)
	private String name;

	@Column(name = "tca_per" ,columnDefinition = "FLOAT ")
	private Double per;

	@Column(name="tca_email",length=30 , unique=true , nullable=false)
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}
}
