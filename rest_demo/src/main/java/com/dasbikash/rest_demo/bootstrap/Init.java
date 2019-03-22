package com.dasbikash.rest_demo.bootstrap;

import com.dasbikash.rest_demo.model.Order;
import com.dasbikash.rest_demo.model.Status;
import com.dasbikash.rest_demo.repo.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dasbikash.rest_demo.model.Employee;
import com.dasbikash.rest_demo.repo.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Init implements CommandLineRunner {

	private EmployeeRepository employeeRepository;
	private OrderRepository orderRepository;

	public Init(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.orderRepository = orderRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("App started");
		employeeRepository.save(new Employee("Bilbo Baggins", "burglar"));
		employeeRepository.save(new Employee("Frodo Baggins", "savior"));

		employeeRepository.findAll().forEach(employee -> {
			log.info("Preloaded employee:" + employee);
		});

		log.info(employeeRepository.findByName("Frodo Baggins").toString());

		orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
		orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

		orderRepository.findAll().forEach(order -> {
			log.info("Preloaded order:" + order);
		});
	}

}
