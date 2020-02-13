package com.kundan.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kundan.demo.model.Employee;
import com.kundan.demo.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/*Save an employee */
	@Transactional
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	/*Search all employee */
	@Transactional
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	/*Get an employee by id */
	@Transactional
	public Optional<Employee> findOne(Long empid) {
		return employeeRepository.findById(empid);
	}
	/*Delete an employee */
	@Transactional
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}

}