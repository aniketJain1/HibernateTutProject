package com.tut.embedding;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentEm {

	@Id
	private int id;
	
	private String name;
	
	private String city;
	
	private CertificateEm certi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CertificateEm getCerti() {
		return certi;
	}

	public void setCerti(CertificateEm certi) {
		this.certi = certi;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", certi=" + certi + "]";
	}

	public StudentEm(int id, String name, String city, CertificateEm certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certi = certi;
	}

	public StudentEm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
