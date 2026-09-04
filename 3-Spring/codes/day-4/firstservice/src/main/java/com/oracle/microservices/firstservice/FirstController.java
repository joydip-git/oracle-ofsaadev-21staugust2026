package com.oracle.microservices.firstservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/first")
public class FirstController {

	@GetMapping(path = "/{name}")
	public ResponseEntity<String> hello(@PathVariable String name) {
		return ResponseEntity.ok("hello " + name);
	}
}
