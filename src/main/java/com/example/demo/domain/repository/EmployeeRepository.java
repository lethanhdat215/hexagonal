package com.example.demo.domain.repository;

import com.example.demo.domain.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepository {
    Employee findById(Long id);

    Employee save(Employee employee);

    List<Employee> findAll();

    void deleteById(Long id);

    Employee update(Employee employee);
}
