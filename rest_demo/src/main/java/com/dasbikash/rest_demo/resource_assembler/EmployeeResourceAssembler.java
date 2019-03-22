package com.dasbikash.rest_demo.resource_assembler;

import com.dasbikash.rest_demo.controllers.EmployeeController;
import com.dasbikash.rest_demo.model.Employee;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class EmployeeResourceAssembler implements ResourceAssembler<Employee, Resource<Employee>> {

    @Override
    public Resource<Employee> toResource(Employee employee) {

        return new Resource<>(employee,
                //linkTo(methodOn(EmployeeController.class).one(employee.get_id())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAll()).withRel("employees"));
    }
}