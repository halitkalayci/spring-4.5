package com.turkcell.intro.web.controller;

import com.turkcell.intro.web.entity.Product;
import com.turkcell.intro.web.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController // Spring tarafından RestController olarak tanınsın.
@RequestMapping("/api/v1/products") // localhost:port/api/v1/products ile başlıyorsa istek buraya gelsin.
public class ProductsController
{
    // Dependency Injection
    private ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // Ekleme endpointleri ekleme sonrası durum için eklenen entity'i geri döner.
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // eğer işlem başarılı olursa, status code olarak şunu dön.
    public Product add(@RequestBody Product product)
    {
        productRepository.save(product);
        return product;
    }
}
