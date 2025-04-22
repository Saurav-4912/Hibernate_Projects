package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "student")
public class Student {

	// Hibernate create sequence
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Column(name="rno") private Integer rno;
	 */

	// Hibernate used by Identity
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name="rno") private Integer rno;
	 */

//	@Id
//	@SequenceGenerator(name = "sg", sequenceName = "tcaseq" , allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "sg")
//	@Column(name="rno")
//	private Integer rno;

	@Id
	@TableGenerator(name = "tg", table = "mytab", pkColumnName = "myid", pkColumnValue = "200", valueColumnName = "next_val", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tg")
	@Column(name = "rno")
	private Integer rno;

	@Column(name = "name")
	private String name;

	@Column(name = "per")
	private Double per;

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
