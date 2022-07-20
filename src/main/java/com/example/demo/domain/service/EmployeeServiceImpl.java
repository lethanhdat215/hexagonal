package com.example.demo.domain.service;

import com.example.demo.domain.model.Employee;
import com.example.demo.domain.port.in.EmployeeService;
import com.example.demo.domain.port.out.EmployeeDbPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDbPort employeeDbPort;

    @Override
    public Employee findById(Long id) {
        return employeeDbPort.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
       return employeeDbPort.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDbPort.findAll();
    }

    @Override
    public void deleteById(Long id) {
        employeeDbPort.deleteById(id);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDbPort.update(employee);
    }
}
