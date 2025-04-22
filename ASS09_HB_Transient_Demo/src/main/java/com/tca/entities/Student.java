package com.tca.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Student {

	@Id
	private Integer rno;

	private String name;

	private Double per;
	
// (If you have a property(Data Member) but you want and you don't want to store this property
//value in the database table then you need to make it transient property by using annotation.)
	@Transient
	private Integer age;

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
