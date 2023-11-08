package com.example.semana9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
 
@Service
public class DatabaseService {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    public boolean isDatabaseConnected() {
        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", Integer.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
 
   public List<Producto> getAllProducts() {
        try {
            // Replace 'app_log' with your actual table name and adjust the query as needed
            String query = "SELECT * FROM productos";
            List<Map<String, Object>> resultProducts = jdbcTemplate.queryForList(query);
            List<Producto> productos = new ArrayList<>();
 
            for (Map<String, Object> row : resultProducts) {
                int id_producto = (int) row.get("id_producto");
                String nombre_producto = (String) row.get("nombre_producto");
    
                String descripcion_producto = (String) row.get("descripcion_producto");
 
                Producto producto = new Producto(id_producto, nombre_producto, descripcion_producto);
                productos.add(producto);
            }
            return productos;
        } catch (Exception e) {
            // Handle exceptions if needed
            e.printStackTrace();
            return null;
        }
    }

    public Producto getProducto(int id) {
        System.out.println("logId = " + id);
        try {
            String query = "SELECT * FROM productos WHERE id_producto = ?";
 
            return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                int id_producto = (int)rs.getInt("id_producto");
                String nombre_producto = rs.getString("nombre_producto");
                String descripcion_producto = rs.getString("descripcion_producto");
              
                return new Producto(id_producto, nombre_producto, descripcion_producto);
            }, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
