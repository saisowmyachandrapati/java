package com.employeemanagementsystem.request;

import com.employeemanagementsystem.entity.Employee;

public class Employeerequest {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Employeerequest [employee=" + employee + "]";
	}

}
