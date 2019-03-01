package com.dasbikash.springbootjersey101.jersey.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dasbikash.springbootjersey101.model.User;

@Path("/api")
public class TestController {

	@GET
	@Path("/hello")
	public String sayHello() {
		return "hello";
	}

	@GET
	@Path("/bikash")
	@Produces(MediaType.TEXT_XML)
	public User getUser() {
		return new User("Bikash");
	}
	
	@GET
	@Path("/getName")
	public String name() {
		return "Bikash";
	}

}
