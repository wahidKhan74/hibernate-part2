package com.simplilearn.hibernatedemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ems_project")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="project_no")
	private String projectNo;
	
	@Column(name="project_title")
	private String projectTiltle;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.PERSIST,
			CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	//constructor
	public Project() {	}

	public Project(String projectNo, String projectTiltle) {
		super();
		this.projectNo = projectNo;
		this.projectTiltle = projectTiltle;
	}
	
	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectTiltle() {
		return projectTiltle;
	}

	public void setProjectTiltle(String projectTiltle) {
		this.projectTiltle = projectTiltle;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	//override toString()
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectNo=" + projectNo + ", projectTiltle=" + projectTiltle + "]";
	}
	
}
