/*
 * ProductEntity.java:
 * Developer: Nathan Meyer
 * 
 * Description: Objects of this class represent products retrieved and created by the application. This class is used by all other
 * classes in the application for processing and fulfilling requests.
 */

package com.milestone.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class ProductEntity {
    
    @Id
    @Column("ID")
    private Long id;

    @Column("NAME")
    private String name;

    @Column("TYPE")
    private String type;

    @Column("SHELFLIFE")
    private Long shelfLife;

    @Column("PRICE")
    private Double price;
    
    public ProductEntity(Long id, String name, String type, Long shelfLife, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.shelfLife = shelfLife;
        this.price = price;
    }

    
    /**
     * ProductModel.getId:
     * Retrieves the value for Id
     * @return Long
     */
    public Long getId() {
        return id;
    }

    
    /**
     * ProductModel.set:
     * Sets the value for Id 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     * ProductModel.getName:
     * Retrieves the value for Name  
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /**
     * ProductModel.setName:
     * Sets the value for Name  
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * ProductModel.getType:
     * Retrieves the value for Type 
     * @return String
     */
    public String getType() {
        return type;
    }

    
    /**
     * ProductModel.setType:
     * Sets the value for Type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    
    /**
     * ProductModel.getShelfLife:
     * Retrieves the value for ShelfLife  
     * @return Long
     */
    public Long getShelfLife() {
        return shelfLife;
    }

    
    /**
     * ProductModel.setShelfLife:
     * Sets the value for ShelfLife  
     * @param shelfLife
     */
    public void setShelfLife(Long shelfLife) {
        this.shelfLife = shelfLife;
    }

    
    /** 
     * ProductModel.getPrice:
     * Retrieves the value for Price
     * @return Double
     */
    public Double getPrice() {
        return price;
    }

    
    /** 
     * ProductModel.setPrice:
     * Sets the value for Price
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

}
