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

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.getProductByid(id);
    }

    @Override
    public ProductEntity create(ProductEntity t) {
        ProductEntity output = productRepository.save(t);
        /* String sql = "INSERT INTO PRODUCTS(NAME, TYPE, SHELFLIFE, PRICE) VALUES(?, ?, ?, ?)";
        try{
            jdbcTemplateObject.update(sql, t.getName(), t.getType(), t.getShelfLife(), t.getPrice());
        }
        catch (Exception e){
            e.printStackTrace();
        } */
        return output;
    }

    @Override
    public ProductEntity update(ProductEntity t, Long id) {
        ProductEntity output = productRepository.save(new ProductEntity(id, t.getName(), t.getType(), t.getShelfLife(), t.getPrice()));
        /* String sql = "UPDATE PRODUCTS SET NAME=?, TYPE=?, SHELFLIFE=?, PRICE=? WHERE ID=?";
        try{
            jdbcTemplateObject.update(sql, t.getName(), t.getType(), t.getShelfLife(), t.getPrice(), id);
        }
        catch (Exception e){
            e.printStackTrace();
        } */
        return output;
    }

    @Override
    public boolean delete(Long id) {
        productRepository.deleteById(id);
        return true;
        /* String sql = "DELETE FROM ALBUM WHERE ID=?";
        try{
            jdbcTemplateObject.update(sql, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return true; */
    }

    
}
