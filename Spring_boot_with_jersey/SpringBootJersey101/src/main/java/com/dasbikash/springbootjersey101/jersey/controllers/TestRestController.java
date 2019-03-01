package com.dasbikash.springbootjersey101.jersey.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/test")
public class TestRestController {
	
	@GET
	public String name() {
		return "Hello from jersey_api";
	}

}
