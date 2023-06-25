package com.tut.mapping_many_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "map_many_to_many_project")
public class Project {

	@Id
	private int pid;
	private String project;
	
	@ManyToMany(mappedBy = "projects")
	private List<Emp> emps;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", project=" + project + ", emps=" + emps + "]";
	}

	public Project(int pid, String project, List<Emp> emps) {
		super();
		this.pid = pid;
		this.project = project;
		this.emps = emps;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
