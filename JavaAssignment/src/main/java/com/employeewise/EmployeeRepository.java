package com.employeewise;

import java.util.List;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.lightcouch.View;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    private final CouchDbClient couchDbClient;

    public EmployeeRepository() {
        couchDbClient = new CouchDbClient("employee", true, "http", "127.0.0.1", 5984, "admin", "root");
    }

    public String saveEmployee(Employee employee) {
        Response employeeDocument = couchDbClient.save(employee);
        return employeeDocument.getId();
    }
    
    public List<Employee> getAllEmployees() {
        View view = couchDbClient.view("_all_docs").includeDocs(true);
        return view.query(Employee.class);
    }
    
    public Response deleteEmployeeById(String id) {
        return couchDbClient.remove(id, null);
    }
    
    public Response deleteEmployeeById(String id, String rev) {
        return couchDbClient.remove(id, rev);
    }

    public Employee getEmployeeById(String id) {
        Employee employee = couchDbClient.find(Employee.class, id);
        if (employee != null) {
            employee.setRev(employee.getRev());
        }
        return employee;
    }
    
    public Response updateEmployee(Employee employee) {
        return couchDbClient.update(employee);
    }
}