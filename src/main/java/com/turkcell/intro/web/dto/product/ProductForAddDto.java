package com.turkcell.intro.web.dto.product;

// Seçeceğiniz 2 entity için dto-service-controller
// yapısını koruyarak add ve getall methodlarını tasarlamak.
public class ProductForAddDto
{
    private String name;
    private String description;
    private float stock;
    private float unitPrice;
    private int categoryId;

    public ProductForAddDto() {
    }

    public ProductForAddDto(String name, String description, float stock, float unitPrice, int categoryId) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
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
}
