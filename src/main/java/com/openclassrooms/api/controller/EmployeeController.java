package com.openclassrooms.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.service.EmployeeService;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Create a new employee
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    //Read one employee
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.orElse(null);
    }

    //Read all employee
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    //Update an employee
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
        Optional<Employee> e = employeeService.getEmployee(id);
        if(e.isPresent()) {
            Employee currentEmployee = e.get();

            String firstName = employee.getFirstName();
            if(firstName != null){
                currentEmployee.setFirstName(firstName);
            }

            String lastName = employee.getLastName();
            if(lastName != null){
                currentEmployee.setLastName(lastName);
            }

            String mail = employee.getMail();
            if(mail != null){
                currentEmployee.setMail(mail);
            }

            String password = employee.getPassword();
            if(password != null){
                currentEmployee.setPassword(password);
            }

            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
        }
        else {
            return null;
        }
    }

    //Delete an employee
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployee(id);
    }
}
