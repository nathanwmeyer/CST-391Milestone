/*
 * ProductModel.java:
 * Developer: Nathan Meyer
 * 
 * Description: Objects of this class represent products retrieved and created by the application. This class is depreciated and is replaced by the
 * identical class ProductEntity.java 
 */

package com.milestone.gcu.model;

public class ProductModel {
    
    private Long id;

    private String name;

    private String type;

    private Long shelfLife;

    private Double price;
    
    public ProductModel(Long id, String name, String type, Long shelfLife, Double price) {
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
