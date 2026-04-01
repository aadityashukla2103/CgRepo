package com.cg.entity;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@DynamicUpdate
@Table(name="abes_emp")
public class Emp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer empID;
	
	@Column(name="emp_name",nullable=false,length=45)
	private String  empName;
	
	@Column(name="emp_sal",nullable=false)
	private Double empSal;
	
	@Column(name="emp_doj")
	private LocalDate empDoj;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Dept dept;
	
	public Integer getEmpID() {
		return empID;
	}
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public LocalDate getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(LocalDate empDoj) {
		this.empDoj = empDoj;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Emp [empID=" + empID + ", empName=" + empName + ", empSal=" + empSal + ", empDoj=" + empDoj + ", dept="
				+ dept + "]";
	}
	
	

}
