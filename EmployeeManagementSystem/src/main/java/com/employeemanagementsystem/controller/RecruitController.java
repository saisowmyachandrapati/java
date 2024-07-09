package com.employeemanagementsystem.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagementsystem.entity.Department;
import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.repository.DepartmentRepository;
import com.employeemanagementsystem.repository.EmployeeRepository;
import com.employeemanagementsystem.request.DepartmentRequestRO;
import com.employeemanagementsystem.request.Employeerequest;
import com.employeemanagementsystem.response.DepartmentResponseRo;

@RestController
public class RecruitController {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/department")
	public DepartmentResponseRo addDepartment(@RequestBody DepartmentRequestRO departmentRequestRO) {

		Department deptRo = departmentRepository.save(departmentRequestRO.getDepartment());
		DepartmentResponseRo resp = new DepartmentResponseRo();

		List<Integer> list = deptRo.getEmployee().stream().map(i -> i.getEmployeeId()).collect(Collectors.toList());

		resp.setDepartmentId(deptRo.getDepartmentId());
		resp.setEmployeeId(list);
		return resp;
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employeerequest employeeRequest) {

		Employee emp = employeeRepository.save(employeeRequest.getEmployee());

		return emp;
	}

	@GetMapping("/depatments")
	public List<Department> allEmployees() {
		return departmentRepository.findAll();
	}

	@GetMapping("/depatments/{id}")
	public Optional<Department> findEmployees(@PathVariable int id) {

		return departmentRepository.findById(id);
	}

	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable int id, @RequestBody Department departmentDetails) {
		Department department = departmentRepository.findById(id).get();

		department.setDepartmentId(id);
		department.setDepartmentName(departmentDetails.getDepartmentName());
		department.setEmployee(departmentDetails.getEmployee());
		System.out.println(department);
		return departmentRepository.save(department);
	}

	@DeleteMapping("/department/{id}")
	public String deleteEmployees(@PathVariable int id) {

		departmentRepository.deleteById(id);
		return "Deleted: " + id;
	}
}
