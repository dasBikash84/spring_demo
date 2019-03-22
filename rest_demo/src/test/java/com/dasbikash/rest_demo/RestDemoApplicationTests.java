package com.dasbikash.rest_demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.test.context.junit4.SpringRunner;

import com.dasbikash.rest_demo.model.CustomLink;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestDemoApplicationTests {

    @Test
    public void contextLoads() {
    }
    
    @Test
    public void customLinkTest() {    	
    	CustomLink link = new CustomLink(new Link("http://localhost:8080/something",Link.REL_NEXT));
		System.out.println(link.toString());
    }

}
