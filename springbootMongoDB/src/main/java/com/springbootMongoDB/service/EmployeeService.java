package com.springbootMongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootMongoDB.entity.Employee;
import com.springbootMongoDB.exception.EntityNotFoundException;
import com.springbootMongoDB.repository.EmployeeRepository;

@Service  
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepo;

  public List<Employee> fetchAll() {
    return employeeRepo.findAll();
  }

  public Employee fetchById(final String id) {
    Optional<Employee> employee = employeeRepo.findById(id);

		if (!employee.isPresent()){
			throw new EntityNotFoundException("id-" + id);
    }
		return employee.get();
  }

  public void delete(final String id) {
    employeeRepo.deleteById(id);
  }

  public Employee create(final Employee employee) {
    return employeeRepo.save(employee);
  }

  public ResponseEntity<Object> update(final Employee employee, final String id) {
    Optional<Employee> employeeOptional = employeeRepo.findById(id);
		if (!employeeOptional.isPresent()) {
			return ResponseEntity.notFound().build();
    }
		employee.setId(id);
		employeeRepo.save(employee);
		return ResponseEntity.noContent().build();
  }

}
