package com.oracle.security.authdaodemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/home")
public class HomeController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }
}
