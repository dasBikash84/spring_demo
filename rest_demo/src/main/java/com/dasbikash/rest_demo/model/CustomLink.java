package com.dasbikash.rest_demo.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

//@ToString
public class CustomLink extends ResourceSupport {

	public CustomLink() {
		super();
	}


	public CustomLink(Link link) {
		super();
		add(link);
	}
	
	

}
