package com.employeemanagementsystem.request;

import com.employeemanagementsystem.entity.Department;

public class DepartmentRequestRO {

	private Department department;

	public DepartmentRequestRO(Department department) {
		this.department = department;
	}

	public DepartmentRequestRO() {

	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "WorkAssign [department=" + department + "]";
	}

}
