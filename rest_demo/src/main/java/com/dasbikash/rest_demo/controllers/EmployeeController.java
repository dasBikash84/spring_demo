package com.dasbikash.rest_demo.controllers;

import com.dasbikash.rest_demo.model.Employee;
import com.dasbikash.rest_demo.model.EmployeeList;
import com.dasbikash.rest_demo.repo.EmployeeRepository;
import com.dasbikash.rest_demo.resource_assembler.EmployeeResourceAssembler;
import com.dasbikash.rest_demo.services.EmployeeService;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class EmployeeController {

    private int count=0;

    private final EmployeeRepository repository;
    private final EmployeeService employeeService;
    private final EmployeeResourceAssembler assembler;

    public EmployeeController(EmployeeRepository repository, EmployeeService employeeService, EmployeeResourceAssembler assembler) {
        this.repository = repository;
        this.employeeService = employeeService;
        this.assembler = assembler;
    }
// Aggregate root

    @GetMapping("/employees")
    public Resources<Resource<Employee>> getAll() {

        EmployeeList employeeList = employeeService.findAll();

        List<Resource<Employee>> resourceList = employeeList
                                    .getEmployeeList()
                                    .stream()
                                    .map(assembler::toResource/*employee -> {
                                        return new Resource<>(employee,
                                                linkTo(methodOn(EmployeeController.class).one(employee.get_id())).withSelfRel(),
                                                linkTo(methodOn(EmployeeController.class).getAll()).withRel("employees")
                                                );
                                    }*/)
                                    .collect(Collectors.toList());

        return new Resources<>(resourceList,
                linkTo(methodOn(EmployeeController.class).getAll()).withSelfRel());


        //return employeeService.findAll();
    }

    @PostMapping("/employees")
    public /*Employee*/ResponseEntity<?> saveNewEmployee(@RequestBody Employee newEmployee) throws URISyntaxException {
        Resource<Employee> employeeResource =
                assembler.toResource(employeeService.save(newEmployee));
        return ResponseEntity
                .created(new URI(employeeResource.getId().expand().getHref()))
                .body(employeeResource);
        //return bodyBuilder
        //return employeeService.save(newEmployee);//repository.save(newEmployee);
    }

    // Single item
    
    @GetMapping("/singemp")
    @ResponseStatus(value = HttpStatus.FOUND)
    public Employee getSingleEmployee(@RequestHeader("username") String userName,@RequestParam("id") Long id,@CookieValue("testCookie") Object o) {
    	Employee employee = employeeService.findById(id);

        System.out.println("User name:"+userName);
        System.out.println("Cookie type:"+o.getClass().getCanonicalName());

    	/*employee.add(linkTo(methodOn(EmployeeController.class).getSingleEmployee(userName,_id)).withSelfRel());
    	employee.add(linkTo(methodOn(EmployeeController.class).getSingleEmployee(userName,_id+1L)).withRel(Link.REL_NEXT));
    	employee.add(linkTo(methodOn(EmployeeController.class).getSingleEmployee(userName,_id-1L)).withRel(Link.REL_PREVIOUS));
    	employee.add(linkTo(methodOn(EmployeeController.class).getSingleEmployee(userName,1L)).withRel(Link.REL_FIRST));
    	employee.add(linkTo(methodOn(EmployeeController.class).getSingleEmployee(userName,2L)).withRel(Link.REL_LAST));*/
        System.out.println(count++);
    	return employee;
    }

    @GetMapping("/employees/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public Resource<Employee> one(@PathVariable Long id) {

        Employee employee = employeeService.findById(id);//.orElseThrow(() -> new EmployeeNotFoundException(_id));;
        
        if(employee == null) {
        	//throw new EmployeeNotFoundException(_id);
        }

        return assembler.toResource(employee);

        /*return new Resource<>(employee,
                linkTo(methodOn(EmployeeController.class).one(_id)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAll()).withRel("employees"));*/
        //return employeeService.findById(_id);/*repository.findById(_id)
                //.orElseThrow(() -> new EmployeeNotFoundException(_id));*/
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?>/*Employee*/ replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) throws URISyntaxException {

        Employee updatedEmployee = repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.set_id(id);
                    return repository.save(newEmployee);
                });

        Resource<Employee> resource = assembler.toResource(updatedEmployee);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);

        /*return repository.findById(_id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.set_id(_id);
                    return repository.save(newEmployee);
                });*/
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
