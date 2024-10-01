package org.example.springbootprojectelasticsearchcrud.controller;

import org.example.springbootprojectelasticsearchcrud.model.Employee;
import org.example.springbootprojectelasticsearchcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public String saveEmployee(@RequestBody Employee employee) {
       return employeeService.saveEmployee(employee);
    }
    @GetMapping("/elastic/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/mongo/{id}")
    public Employee getEmployeeById1(@PathVariable Long id) {
        return employeeService.getEmployeeById1(id);
    }

    @GetMapping("/elastic")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/mongo")
    public Iterable<Employee> getAllEmployees1() {
        return employeeService.getAllEmployees1();
    }


    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "data deleted with this id  "+id;
    }

    @DeleteMapping
    public String deleteAllEmployee() {
        return employeeService.deleteAllEmployees();
    }

    @PutMapping("/elastic")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployeeElastic(employee);
    }

    @PutMapping("/mongo")
    public String updateEmployee1(@RequestBody Employee employee) {
        return employeeService.updateEmployee1(employee);
    }
}

