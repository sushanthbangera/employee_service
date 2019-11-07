package com.glarimy.quiz.employee.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.glarimy.quiz.employee.domain.Employee;
import com.glarimy.quiz.employee.service.EmployeeService;

import io.swagger.annotations.SwaggerDefinition;

@RestController
@Validated
@CrossOrigin
@SwaggerDefinition
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/employee")
	public ResponseEntity<Employee> post(@RequestBody @Valid Employee employee, UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();
		employee = service.add(employee);
		headers.setLocation(builder.path("/employee/{eid}").buildAndExpand(employee.getEid()).toUri());
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.CREATED);
	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> list() {
		List<Employee> employees = service.list();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("/employee/{eid}")
	public ResponseEntity<Employee> get(@PathVariable("eid") String eid) {
		Employee employee = service.get(eid);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

}
