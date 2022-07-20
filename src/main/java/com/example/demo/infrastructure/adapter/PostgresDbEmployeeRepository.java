package com.example.demo.infrastructure.adapter;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.domain.model.Employee;
import com.example.demo.domain.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class PostgresDbEmployeeRepository implements EmployeeRepository, GraphQLQueryResolver {
    @Autowired
    private com.example.demo.infrastructure.repository.EmployeeRepository employeeRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Employee findById(Long id) {
        com.example.demo.infrastructure.entity.Employee employeeI = employeeRepository.findById(id).get();
        Employee employeeD = modelMapper.map(employeeI, Employee.class);
        if (employeeD != null) return employeeD;
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        com.example.demo.infrastructure.entity.Employee employeeI = modelMapper.map(employee, com.example.demo.infrastructure.entity.Employee.class);
        employeeI = employeeRepository.save(employeeI);
        Employee employeeD = modelMapper.map(employeeI,Employee.class);
        return employeeD;
    }

    @Override
    public List<Employee> findAll() {
        List<com.example.demo.infrastructure.entity.Employee> employeeI = employeeRepository.findAll();
        List<Employee> employeeD = new ArrayList<>();
        for (com.example.demo.infrastructure.entity.Employee employee : employeeI) {
            Employee employeeD1 = modelMapper.map(employee, Employee.class);
            employeeD.add(employeeD1);
        }
        return employeeD;
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee employee) {
        com.example.demo.infrastructure.entity.Employee employeeI = employeeRepository.findById(employee.getId()).orElseThrow(() -> new RuntimeException("id doesn't exist"));
        employeeI.setFirstName(employee.getFirstName());
        employeeI.setLastName(employee.getLastName());
        employeeI.setAddress(employee.getAddress());
        employeeRepository.save(employeeI);
        Employee employeeD = modelMapper.map(employeeI, Employee.class);
        return employeeD;
    }
}
