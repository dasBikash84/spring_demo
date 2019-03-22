package com.dasbikash.rest_demo.repo;

import com.dasbikash.rest_demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //@Override
    Employee findByName(String name);
}
