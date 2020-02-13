package com.kundan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kundan.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
