package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;

@RestController
public class Controller {

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/get")
	public Employee getEmployee(@RequestParam long id) {
		return empRepo.findById(id);
	}

	@GetMapping("/getall")
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@PostMapping("/post")
	public String saveEmployee(@RequestParam String name, @RequestParam String role) {
		empRepo.save(new Employee(name, role));
		return "Employee " + name + " Added Successfully :)";

	}

	@PutMapping("/put")
	public String updateEmployee(@RequestParam long id, @RequestParam String name, @RequestParam String role) {

		Employee emp = empRepo.findById(id);
		emp.setName(name);
		emp.setRole(role);
		empRepo.save(emp);
		return "Emplyee Updated Successfully";

	}

	@DeleteMapping("/put")
	public String updateEmployee1(@RequestParam long id) {
		empRepo.deleteById(id);
		return "Emplyee with id=" + id + " Successfully Deleted";

	}

}
