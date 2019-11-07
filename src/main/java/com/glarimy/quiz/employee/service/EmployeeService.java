package com.glarimy.quiz.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glarimy.quiz.employee.data.EmployeeRepository;
import com.glarimy.quiz.employee.domain.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public Employee add(Employee employee) {
		return repo.save(employee);
	}

	public Employee get(String eid) {
		return repo.findById(eid).orElseThrow(() -> new RuntimeException());
	}

	public List<Employee> list() {
		return repo.findAll();
	}
}
