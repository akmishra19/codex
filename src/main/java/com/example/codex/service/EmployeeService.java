package com.example.codex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codex.entity.Employee;
import com.example.codex.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

    @Cacheable(value = "sampleCache")
	public List<Employee> getAllEmployees(){
		List<Employee> eList= new ArrayList<>();
		eList=employeeRepository.findAll();
		return eList;
	}
	
}
