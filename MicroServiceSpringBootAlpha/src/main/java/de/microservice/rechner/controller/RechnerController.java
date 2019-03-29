package de.microservice.rechner.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RechnerController {

    @RequestMapping(value = "/", method = GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
