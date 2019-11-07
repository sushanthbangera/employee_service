package com.glarimy.quiz.employee.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.glarimy.quiz.employee.domain.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
