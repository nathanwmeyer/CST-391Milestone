/*
 * ProductDataService.java:
 * Developer: Nathan Meyer
 * 
 * Description: This class implements DataAccessInterface and is in charge of managing transactions with the MySQL database. This method follows the
 * CRUD (Create, Read, Update, Delete) design pattern.
 */

package com.milestone.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.milestone.gcu.data.entity.ProductEntity;
import com.milestone.gcu.data.repository.ProductRepository;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity>{
    
    @Autowired
    private ProductRepository productRepository;

    @SuppressWarnings("unused")
    private DataSource dataSource;
    @SuppressWarnings("unused")
    private JdbcTemplate jdbcTemplateObject;

    public ProductDataService(ProductRepository productRepository, DataSource dataSource)
    {
        this.productRepository = productRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    
    /** 
     * ProductDataService.findAll:
     * Uses ProductRepository to find and return a list of ProductEntities to the calling class.
     * @return List<ProductEntity>
     */
    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> product = new ArrayList<ProductEntity>();

        try{
            Iterable<ProductEntity> productIterable = productRepository.findAll();

            productIterable.forEach(product::add);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return product;
    }

    
    /**
     * ProductDataService.findById:
     * Takes an id and uses ProductRepository to find and return a ProductEntity that contains the product with the matching id value.
     * Returns null if it cannot find a product with a matching id 
     * @param id
     * @return ProductEntity
     */
    @Override
    public ProductEntity findById(Long id) {
        return productRepository.getProductByid(id);
    }

    
    /**
     * ProductDataService.create:
     * Takes a ProductEntity from the calling class and attempts to save it to the database using ProductRepository.
     * Returns the created ProductEntity if the operation is a success, otherwise it returns null to signal that the operation failed. 
     * @param t
     * @return ProductEntity
     */
    @Override
    public ProductEntity create(ProductEntity t) {
        ProductEntity output = productRepository.save(t);
        return output;
    }

    
    /** 
     * ProductDataService.update:
     * Takes a ProductEntity and id from the calling class and attempts to use ProductRepository to update the product in the database
     * with a matching id. Returns the created ProductEntity if the operation is a success, otherwise it returns null to signal that the
     * operation failed.
     * @param t
     * @param id
     * @return ProductEntity
     */
    @Override
    public ProductEntity update(ProductEntity t, Long id) {
        ProductEntity output = productRepository.save(new ProductEntity(id, t.getName(), t.getType(), t.getShelfLife(), t.getPrice()));
        return output;
    }

    
    /**
     * ProductDataService.delete:
     * Takes an id from the calling class and attempts to use ProductRepository to delete the product in the database with a matching id.
     * Returns true regardless of the id given 
     * @param id
     * @return boolean
     */
    @Override
    public boolean delete(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    
}
