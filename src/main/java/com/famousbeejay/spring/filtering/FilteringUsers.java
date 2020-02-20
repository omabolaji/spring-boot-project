package com.famousbeejay.spring.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringUsers {


	//field1, field2
	@GetMapping(path="/filtering")
	public MappingJacksonValue filteringUsers() {
		
		SomeBeans someBeans = new SomeBeans("val1","val2","val3", "val4");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1", "field2");
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeansFiltering", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	//field3, field2
	@GetMapping("/filtering-list")
	public MappingJacksonValue viewAllBeans(){
		
		List<SomeBeans> someBeans = Arrays.asList(
				new SomeBeans("val1","val2","val3", "val4"),
				new SomeBeans("val12","val23","val34", "val45"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1", "field3");
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeansFiltering", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
		mapping.setFilters(filters);
		
		return mapping;
	}
}
