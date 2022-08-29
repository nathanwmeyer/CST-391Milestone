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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Long shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
