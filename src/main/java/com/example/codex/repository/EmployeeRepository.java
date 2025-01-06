package com.example.codex.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.codex.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	//List<Employee> findAll();
	
	@Query(value="Select * from Employee", nativeQuery=true)
	List<Employee> findAll();
	
	Employee findByName(String EmployeeName);
}
