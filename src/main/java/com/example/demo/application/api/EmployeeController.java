package com.example.demo.application.api;

import com.example.demo.domain.model.Employee;
import com.example.demo.domain.port.in.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employee));
    }

        @GetMapping()
//    @SchemaMapping(typeName = "Query", value = "findAll")
    ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
    }

    @DeleteMapping("/{id}")
    void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

    @PutMapping()
    ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(employee));
    }
}
