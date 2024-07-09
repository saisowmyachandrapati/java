package com.employeemanagementsystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author admin Dmantz
 * @version  0.2 all good
 */
@Entity
@Table(name = "Department")
public class Department {
	@Id
	@GeneratedValue
	private int departmentId;
	@Column(name = "departmentName")
	private String departmentName;

	@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "department_Id", referencedColumnName = "departmentId")
	List<Employee> employee;

	public Department(int departementId, String departmentName, List<Employee> employee) {
		super();
		this.departmentId = departementId;
		this.departmentName = departmentName;
		this.employee = employee;
	}

	public Department() {

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departementId) {
		this.departmentId = departementId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Department [departementId=" + departmentId + ", departmentName=" + departmentName + ", employee="
				+ employee + "]";
	}

}
