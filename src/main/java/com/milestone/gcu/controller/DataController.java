package com.milestone.gcu.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.milestone.gcu.data.ProductDataService;
import com.milestone.gcu.data.entity.ProductEntity;

@RestController
public class DataController {

    @Autowired
    private ProductDataService service;

    @GetMapping("/")
	public String home()
	{		
		return "This is home";
	}
    
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable Long id)
    {
        ProductEntity product = service.findById(id);
        if (product == null){
            Map<String, String> body = new HashMap<>();
            body.put("message", "That product with that ID cannot be found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(product);
        }
    }
    
    @GetMapping("/products")
    public ResponseEntity<?> getProducts()
    {
        List<ProductEntity> products = service.findAll();
        if (products == null) {
            Map<String, String> body = new HashMap<>();
            body.put("message", "The products could not be found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(products);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<?> postProduct(@RequestBody ProductEntity product)
    {
        ProductEntity result = service.create(product);
        if (result == null) {
            Map<String, String> body = new HashMap<>();
            body.put("message", "There was an issue with the posted product, it could not be added");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/products/{id}").buildAndExpand(result.getId()).toUri();

            return ResponseEntity.created(uri).body(result);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductEntity product, @PathVariable Long id)
    {
        ProductEntity result = service.update(product, id);
        if (result == null) {
            Map<String, String> body = new HashMap<>();
            body.put("message", "There was an issue with the posted product, it could not be updated");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(result);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id)
    {
        service.delete(id);
        Map<String, String> body = new HashMap<>();
            body.put("message", "The Delete action was a success");
            return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
    }
}
