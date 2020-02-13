package com.kundan.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kundan.demo.dao.EmployeeDAO;
import com.kundan.demo.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	/* To save an employee*/
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}
	
	/* Get all employee*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}

	/* Get employee by id*/
	@GetMapping("/notes/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable(value = "id")Long id){
		//Employee emp=employeeDAO.findOne(id).get();
		if(employeeDAO.findOne(id).isPresent()) {
		//	return ResponseEntity.notFound().build();
			return employeeDAO.findOne(id);
		}
	//	return ResponseEntity.ok().body(emp)
		return null;
	}
	
	/* Update an employee by id*/
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid,@Valid @RequestBody Employee empDetails){
		Employee emp=employeeDAO.findOne(empid).get();
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDesination(empDetails.getDesination());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee=employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	/* Delete an employee*/
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		Employee emp=employeeDAO.findOne(empid).get();
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
}
