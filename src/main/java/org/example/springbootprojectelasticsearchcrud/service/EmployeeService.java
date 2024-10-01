package org.example.springbootprojectelasticsearchcrud.service;

import org.example.springbootprojectelasticsearchcrud.model.Employee;
import org.example.springbootprojectelasticsearchcrud.repository.elastic.EmployeeElasticRepo;
import org.example.springbootprojectelasticsearchcrud.repository.mongodb.EmployeeMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeElasticRepo employeeRepository;
    @Autowired
    private EmployeeMongoRepo employeeMongoRepo;

    public String saveEmployee(Employee employee)
    {
        employeeRepository.save(employee);


        employeeMongoRepo.save(employee);
        return "employee data saved successfully";
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    public Employee getEmployeeById1(Long id) {
        Optional<Employee> employee = employeeMongoRepo.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    public Iterable<Employee> getAllEmployees() {
        Iterable<Employee> list=employeeRepository.findAll();
        if(list!=null) {
            return list;
        }else{
            return null;
        }
    }

    public Iterable<Employee> getAllEmployees1(){
        Iterable<Employee> list=employeeMongoRepo.findAll();
        if(list!=null) {
            return list;
        }else{
            return null;
        }
    }

    public void deleteEmployeeById(Long id) {

            employeeRepository.deleteById(id);
            employeeMongoRepo.deleteById(id);

    }


    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        employeeMongoRepo.deleteAll();
        return "all data deleted";
    }

    public String updateEmployeeElastic(Employee employee) {
        Optional<Employee> employee1=employeeRepository.findById(employee.getId());
        if (employee1.isPresent()) {
             Employee employee2 = employee1.get();
             employee2.setId(employee.getId());
             employee2.setName(employee.getName());
             employee2.setDepartment(employee.getDepartment());
             employee2.setSalary(employee.getSalary());
             employeeRepository.save(employee2);
             return "employee data updated successfully";
        }else{
            return "data not found";
        }
    }

    public String updateEmployee1(Employee employee) {
        Optional<Employee> employee1=employeeMongoRepo.findById(employee.getId());
        if (employee1.isPresent()) {
            Employee employee2 = employee1.get();
            employee2.setId(employee.getId());
            employee2.setName(employee.getName());
            employee2.setDepartment(employee.getDepartment());
            employee2.setSalary(employee.getSalary());
            employeeMongoRepo.save(employee2);
            return "employee data updated successfully";
        }else{
            return "data not found";
        }
    }
}




