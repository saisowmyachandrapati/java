package com.employeemanagementsystem.response;

public class EmployeeResponse {
	private int departmentId;
	private int employeeId;

	public EmployeeResponse(int departmentId, int employeeId) {
		super();
		this.departmentId = departmentId;
		this.employeeId = employeeId;
	}

	public EmployeeResponse() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [departmentId=" + departmentId + ", employeeId=" + employeeId + "]";
	}
}
