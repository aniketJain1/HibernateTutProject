package com.tut.mapping_many_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "map_many_to_many_emp")
public class Emp {
	
	@Id
	private int eid;
	private String name;
	
	@ManyToMany
	@JoinTable(name = "emp_learn",
	joinColumns = {@JoinColumn(name = "eid")},
	inverseJoinColumns = {@JoinColumn(name = "pid")})
	private List<Project> projects;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", name=" + name + ", projects=" + projects + "]";
	}

	public Emp(int eid, String name, List<Project> projects) {
		super();
		this.eid = eid;
		this.name = name;
		this.projects = projects;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
