package com.springbootMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springbootMongoDB.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
  
}