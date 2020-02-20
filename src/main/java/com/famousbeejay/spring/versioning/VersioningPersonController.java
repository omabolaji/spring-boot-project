package com.famousbeejay.spring.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 personv1() {
		
		return new PersonV1("Folake kemi");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personv2() {
		
		return new PersonV2(new Name("Bolaji", "Folami"));
	}
	
	//using params to pass the version
	@GetMapping(value="/person/params", params="version=1" )
	public PersonV1 paramv1() {
		
		return new PersonV1("Folake kemi");
	}
	
	//using params to pass the version
	@GetMapping(value="/person/params", params="version=2")
	public PersonV2 paramv2() {
		
		return new PersonV2(new Name("Bolaji", "Folami"));
	}
	
	
		//using headers to pass the version
		@GetMapping(value="/person/headers", headers="X-API-VERSION=1" )
		public PersonV1 headerV1() {
			
			return new PersonV1("Folake kemi");
		}
		
		//using headers to pass the version
		@GetMapping(value="/person/headers", headers="X-API-VERSION=2")
		public PersonV2 headerV2() {
			
			return new PersonV2(new Name("Bolaji", "Folami"));
		}
	
				//using produces to pass the version
				//you can use xml or json
				@GetMapping(value="/person/produces", produces ="application/vnd.company.app-v1+xml" )
				public PersonV1 producesV1() {
					
					return new PersonV1("Folake kemi");
				}
				
				//using produces to pass the version
				//you can use xml or json
				@GetMapping(value="/person/produces", produces ="application/vnd.company.app-v2+xml" )
				public PersonV2 producesV2() {
					
					return new PersonV2(new Name("Bolaji", "Folami"));
				}
		
	
}
