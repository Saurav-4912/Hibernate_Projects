package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")

//@Table
public class Student {

	@Id
	@Column(name = "rno")
	private Integer rno;

	@Column(name = "sname", nullable = false)
	private String name;

	@Column(name = "per")
	private Double per;

	/*
	  @Id private Integer rno;
	  
	  private String name;
	  
	  private Double per;
	*/

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
