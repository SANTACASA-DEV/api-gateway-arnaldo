package br.com.santacasa.api_gateway.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@RestController
@RequestMapping("/")
public class SampleRestController {
    
    @GetMapping("/")
    public void redirectToLogin(HttpServletResponse response)throws IOException {
        response.sendRedirect("/auth/login");
    }
}
