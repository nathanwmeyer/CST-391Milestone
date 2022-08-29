package com.milestone.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.milestone.gcu.data.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity getProductByid(Long id);
}
