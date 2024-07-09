package com.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagementsystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
