package com.kundan.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.kundan.demo.exception.ResourceNotFoundException;
import com.kundan.demo.model.Employee;
import com.kundan.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/* To save an employee*/
	@PostMapping("/save")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	
	/* Get all employee */
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}

	/* Get an employee by id*/
	@GetMapping("/fetch/{id}")
	public Employee getEmployeeByIds(@PathVariable(value = "id")Long empId)throws ResourceNotFoundException {
		return employeeService.getEmployeeById(empId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + empId));
	}
	
	/* Update an employee by id*/
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empId, @Valid @RequestBody Employee employee) throws ResourceNotFoundException{
		Employee emp=employeeService.getEmployeeById(empId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + empId));
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		final Employee updatedEmployee=employeeService.saveEmployee(emp);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	/* Delete an employee by id*/
	@DeleteMapping("/delete/{id}")
	public Map<String,Boolean> deleteEmployeeById(@PathVariable(value = "id")Long empId) throws ResourceNotFoundException {
		Employee employee=employeeService.getEmployeeById(empId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + empId));
		employeeService.deleteEmployee(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
