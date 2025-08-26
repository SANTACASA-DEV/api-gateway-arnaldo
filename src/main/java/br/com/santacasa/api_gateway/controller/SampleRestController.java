package br.com.santacasa.api_gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class SampleRestController {
    
    @GetMapping("/microservice")
    public String getHello() {
        return "Hello, World!";
    }
}
