package com.employeemanagementsystem.response;

import java.util.List;

public class DepartmentResponseRo {
	private int departmentId;
	private List<Integer> employeeId;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public List<Integer> getEmployeeIds() {
		return employeeId;
	}

	public void setEmployeeId(List<Integer> employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "DepartmentResponseRo [departmentId=" + departmentId + ", employeeIds=" + employeeId + "]";
	}

}
