package com.example.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	//GET
	//URI - /hello-world
	//method - "Hello World"
	//Using GetMapping you don't need to specify the method =RequestMethod.GET
	//If you are using RequestMapping then you need to define the method as GET, PUT, Post or DELETE etc.
	//for ex. RequestMethod.GET
	@GetMapping(path="/hello-world")
	
	public String helloWorld() {
		return "Hello World";//string back
	}
	
//hello-world-bean
	//instead of string we want to return a bean back
@GetMapping(path="/hello-world-bean")
	
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");//bean back
		//this helloWorldBean does not have getter, that's why it is giving error as "No converter found for return value of type".
		//If we don't create getter then the automatic conversion will not work.
		//will give json structure as an output
	}
@GetMapping(path="/hello-world/path-variable/{name}")
public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
	return new HelloWorldBean(String.format("Hello World, %s", name));//%s would be replaced by name and this hello world bean would be return back
}

}
