package com.dasbikash.rest_demo.services;

import org.springframework.stereotype.Service;

import com.dasbikash.rest_demo.exceptions.EmployeeNotFoundException;
import com.dasbikash.rest_demo.model.Employee;
import com.dasbikash.rest_demo.model.EmployeeList;
import com.dasbikash.rest_demo.repo.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeList findAll(){
        return new EmployeeList(employeeRepository.findAll());
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee save(Employee newEmployee){
        try {
            return employeeRepository.save(newEmployee);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


}
