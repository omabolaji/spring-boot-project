package com.famousbeejay.spring.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method= RequestMethod.GET, path="/hello")
	public String helloWorld() {
		
		return "Hello wolrd, im here with you";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello world from bean");
	}

	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVarible(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello world from path variable %s", name));
	}
	
	@GetMapping(path="/hello-internationalize")
	public String helloWorldInternationalize(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
		
		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
