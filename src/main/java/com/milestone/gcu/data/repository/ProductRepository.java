/*
 * ProductRepository.java:
 * Developer: Nathan Meyer
 * 
 * Description: This interface extends CrudRepository and is called on by classes to perform direct interactions with the MySQL database.
 */

package com.milestone.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.milestone.gcu.data.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity getProductByid(Long id);
}
