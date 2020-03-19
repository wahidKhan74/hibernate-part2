package com.simplilearn.hibernatedemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ems_payroll")
public class Payroll {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="basic_pay")
	private String basicPay;
	
	@Column(name="gross_pay")
	private String grossPay;
	
	@Column(name="net_pay")
	private String netPay;
	
	@Column(name="pf")
	private String pf;
	
//	@OneToOne(mappedBy="payroll", cascade=CascadeType.ALL)
	@OneToOne(mappedBy="payroll", 
			cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
						CascadeType.REFRESH})
	private Employee employee;
	
	//constructor
	Payroll(){ }
	
	

	public Payroll(String basicPay, String grossPay, String netPay, String pf) {
		super();
		this.basicPay = basicPay;
		this.grossPay = grossPay;
		this.netPay = netPay;
		this.pf = pf;
	}



	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(String basicPay) {
		this.basicPay = basicPay;
	}

	public String getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(String grossPay) {
		this.grossPay = grossPay;
	}

	public String getNetPay() {
		return netPay;
	}

	public void setNetPay(String netPay) {
		this.netPay = netPay;
	}

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	
	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	//override tostring 
	@Override
	public String toString() {
		return "Payroll [id=" + id + ", basicPay=" + basicPay + ", grossPay=" + grossPay + ", netPay=" + netPay
				+ ", pf=" + pf + "]";
	}
	
	
	
	
}
