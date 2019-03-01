package com.dasbikash.springbootjersey101;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.xml.JacksonXMLProvider;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		super();
		register(JacksonXMLProvider.class);
		packages("com.dasbikash.springbootjersey101.jersey");
	}

}
