package com.dms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String mobile;
	private int age;
	private String sex;
	private String status;
	private Date apponitmentdate;

	public Patient() {

	}

	public Date getApponitmentdate() {
		return apponitmentdate;
	}

	public void setApponitmentdate(Date apponitmentdate) {
		this.apponitmentdate = apponitmentdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", age=" + age
				+ ", sex=" + sex + ", status=" + status + ", apponitmentdate=" + apponitmentdate + "]";
	}

}
