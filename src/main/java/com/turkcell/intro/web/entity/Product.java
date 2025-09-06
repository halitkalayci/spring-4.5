package com.turkcell.intro.web.entity;

import jakarta.persistence.*;

@Entity()
@Table(name="products")
public class Product
{
    @Id
    @Column(name="id") // Opsiyonel
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name") // Aynı isim kullanılacaksa gerekli değildir.
    private String name;
    @Column(name="unit_price")
    private float unitPrice;
    @Column(name="stock")
    private float stock;
    @Column(name="description")
    private String description;
    @ManyToOne() // FK hangi tabloda ise. Ona ManyToOne diğerine OneToMany
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
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
}

// Many to Many
// One To One

// Önceki ödevde geliştirdiğiniz kütüphane ER diagramı
// code first yapı ile kurunuz.
