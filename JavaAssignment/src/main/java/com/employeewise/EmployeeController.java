package com.employeewise;

import java.util.List;

import org.lightcouch.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @DeleteMapping("/delete/{id}")
    public Response deleteEmployeeById(@PathVariable String id) {
        return employeeService.deleteEmployeeById(id);
    }
    
    @PutMapping("/update/{id}")
    public Response updateEmployeeById(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployeeById(id, updatedEmployee);
    }
}