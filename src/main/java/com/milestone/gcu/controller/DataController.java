/*
 * DataController.java:
 * Developer: Nathan Meyer
 * 
 * Description: This class is the routing controller for the application. This class is primarily a REST controller, which means that it
 * only provides JSON objects 
 */

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

    
    /** 
     * DataController.home:
     * This is the home route. This only returns a small string on the top of the page.
     * @return String
     */
    @GetMapping("/")
	public String home()
	{		
		return "This is home";
	}
    
    
    /** 
     * DataController.getProductByID:
     * Uses ProductDataService to retrieve a specific product from the database by taking its ID as a Path Variable. If there is
     * no product that has the same ID as the request, a "Product not found" message is displayed in. The product is presented as a
     * JSON object
     * @param id
     * @return ResponseEntity<?>
     */
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
    
    
    /**
     * DataController.getProducts:
     * Uses ProductDataService to retrieve a list of all products in the database. The product list is presented as a
     * JSON object
     * @return ResponseEntity<?>
     */
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

    
    /**
     * DataController.postProduct:
     * Takes a product in JSON form from the Request Body and attempts to POST it to the database using ProductDataService. If the POST
     * attempt fails, an error message is displayed as a JSON object. If the POST attempt is a success, the posted object is returned as
     * a JSON object
     * @param product
     * @return ResponseEntity<?>
     */
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

    
    /**
     * DataController.update:
     * Takes a product in JSON form from the Request Body and an ID from the Path Variable and attempts to update the object with the same
     * ID in the database using ProductDataService. If the PUT attempt fails, an error message is displayed as a JSON object. If the PUT
     * attempt is a success, the posted object is returned as a JSON object 
     * @param product
     * @param id
     * @return ResponseEntity<?>
     */
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

    
    /**
     * DataController.deleteProduct:
     * Takes an ID from the Path Variable and attempts to delete the product with the same ID from the database using
     * ProductDataService. This method will always return a message saying that the product has been deleted. 
     * @param id
     * @return ResponseEntity<Object>
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id)
    {
        service.delete(id);
        Map<String, String> body = new HashMap<>();
            body.put("message", "The product has been deleted.");
            return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
    }
}
