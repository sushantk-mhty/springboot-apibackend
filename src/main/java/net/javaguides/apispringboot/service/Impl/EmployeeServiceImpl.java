package net.javaguides.apispringboot.service.Impl;

import net.javaguides.apispringboot.exception.ResourceNotFoundException;
import net.javaguides.apispringboot.model.Employee;
import net.javaguides.apispringboot.repository.EmployeeRepository;
import net.javaguides.apispringboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long Id) {
        Optional<Employee> employee=employeeRepository.findById(Id);
//        if (employee.isPresent()){
//            return employee.get();
//        }else{
//            throw new ResourceNotFoundException("Employee","Id",Id);
//        }
        return employeeRepository.findById(Id).orElseThrow(()->
                new ResourceNotFoundException("Employee","Id",Id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //we need to check whether employee with give id is exist in DB or not
        Employee existingemployee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","Id",id));

        existingemployee.setFirstName(employee.getFirstName());
        existingemployee.setLastName(employee.getLastName());
        existingemployee.setEmailId(employee.getEmailId());

        //save existing employee DB
        employeeRepository.save(existingemployee);
        return existingemployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check wherther a employee exist in a DB or not

        employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
