package com.employeewise;

import java.util.List;
import java.util.UUID;

import org.lightcouch.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String addEmployee(Employee employee) {
        employee.setId(UUID.randomUUID().toString()); 
        return employeeRepository.saveEmployee(employee);
    }
    
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
    
    public Response deleteEmployeeById(String id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            return employeeRepository.deleteEmployeeById(employee.getId(), employee.getRev());
        } else {
            return null;
        }
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }
    
    public Response updateEmployeeById(String id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            updatedEmployee.setId(existingEmployee.getId());
            updatedEmployee.setRev(existingEmployee.getRev());
            return employeeRepository.updateEmployee(updatedEmployee);
        } else {
            return null;
        }
    }
}
