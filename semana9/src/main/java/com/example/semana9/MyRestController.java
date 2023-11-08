package com.example.semana9;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    
    DatabaseService databaseService = new DatabaseService();
    @GetMapping
    public String hello() {
        return "Hello";
    }
    
    @GetMapping("/all")
    public List<Producto> all(){
        return databaseService.getAllProducts();
    }
}
