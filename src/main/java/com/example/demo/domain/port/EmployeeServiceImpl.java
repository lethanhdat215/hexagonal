package com.example.demo.domain.port;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.domain.model.Employee;
import com.example.demo.domain.repository.EmployeeRepository;
import com.example.demo.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }
}
