package com.turkcell.intro.web.dto.product.response;

import com.turkcell.intro.web.entity.Category;

public class GetByIdProductResponse
{
    private int id;
    private String name;
    private float stock;
    private String description;
    private float unitPrice;
    private int categoryId;
    private String categoryName;

    public GetByIdProductResponse(int id, String name, float stock, String description, float unitPrice, int categoryId, String categoryName) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.description = description;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public GetByIdProductResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
