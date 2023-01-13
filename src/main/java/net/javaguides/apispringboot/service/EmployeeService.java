package net.javaguides.apispringboot.service;

import net.javaguides.apispringboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long Id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);

}
