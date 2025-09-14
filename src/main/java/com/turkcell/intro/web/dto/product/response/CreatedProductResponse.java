package com.turkcell.intro.web.dto.product.response;

// DTO
public class CreatedProductResponse
{
    private int id;
    private String name;
    private float stock;
    private String description;
    private float unitPrice;
    private String categoryName;
    private int categoryId;



    public CreatedProductResponse() {
    }

    public CreatedProductResponse(int id, String name, float stock, String description, float unitPrice, String categoryName) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.description = description;
        this.unitPrice = unitPrice;
        this.categoryName = categoryName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
}
