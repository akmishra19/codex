package com.example.codex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.codex.entity.Employee;
import com.example.codex.entity.User;
import com.example.codex.repository.UserRepository;
import com.example.codex.service.EmployeeService;
import com.example.codex.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "My API Controller", tags = { "Example Controller" })
@RestController
public class BasicController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@ApiOperation(value = "Get all employees", notes = "Fetches all employee records")
	@GetMapping("/getAllEmployees")
	public List<Employee> getEmployees() {
		System.out.println("GET request received for /getAllEmployees");

		return employeeService.getAllEmployees();
	}

	@GetMapping("/getUser")
	public List<User> getUser() {
		System.out.println("GET request received for /getUser");

		return userRepository.findAll();
	}

	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {

		userService.saveUser(user);
	}

}
