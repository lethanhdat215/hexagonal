package com.example.demo.domain.port.in;

import com.example.demo.domain.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee findById(Long id);

    Employee save(Employee employee);

    List<Employee> findAll();

    void deleteById(Long id);

    Employee update(Employee employee);
}
