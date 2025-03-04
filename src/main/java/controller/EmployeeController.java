package controller;

import entity.EmployeeEntity;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@EnableWebSecurity
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService; // Add this field

    public EmployeeController(EmployeeService employeeService) { // Add constructor
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
          Employee employee  = employeeService.getEmployeeById(employeeId);
        if (employee != null ) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employeeIds")
    public ResponseEntity<List<Employee>> getEmployees(@PathVariable List<Long> employeeIds) {
        List<Employee> employees  = employeeService.getEmployeesByIds(employeeIds);
        if (employees != null) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }








}

