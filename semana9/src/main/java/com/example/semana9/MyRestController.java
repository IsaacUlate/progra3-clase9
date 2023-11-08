package com.example.semana9;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



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
    
    @GetMapping("/byid")
    public Producto all(int id) {
        return databaseService.getProducto(id) ;
    }

    @PutMapping("/byid")
    public void update(String nombre, String descripcion, int id) {
 
        Producto    producto = new Producto(id, nombre, descripcion);
        databaseService.updateProducto(producto) ;
    }

    @PostMapping("/all")
    public void insert(String nombre, String descripcion) {
 
        Producto    producto = new Producto(0,nombre, descripcion);
        databaseService.insertProducto(producto) ;
    }

    @DeleteMapping("/byid")
    public void delete(int id) {
 
        databaseService.deleteProducto(id) ;
    }
}
