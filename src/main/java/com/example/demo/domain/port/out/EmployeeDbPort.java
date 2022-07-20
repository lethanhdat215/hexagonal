package com.example.demo.domain.port.out;

import com.example.demo.domain.model.Employee;

import java.util.List;


public interface EmployeeDbPort {
    Employee findById(Long id);

    Employee save(Employee employee);

    List<Employee> findAll();

    void deleteById(Long id);

    Employee update(Employee employee);
}
