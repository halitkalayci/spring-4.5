package com.turkcell.intro.web.controller;

import com.turkcell.intro.web.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController // Spring tarafından RestController olarak tanınsın.
@RequestMapping("/api/v1/products") // localhost:port/api/v1/products ile başlıyorsa istek buraya gelsin.
public class ProductsController
{
    // Ram'de tutulur.
    private List<Product> products = new ArrayList<Product>();

    @GetMapping()
    public List<Product> getAll() {
        return products;
    }

    // Ekleme endpointleri ekleme sonrası durum için eklenen entity'i geri döner.
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // eğer işlem başarılı olursa, status code olarak şunu dön.
    public Product add(@RequestBody Product product)
    {
        // ekleme.
        Random randon = new Random();
        product.setId(randon.nextInt(1000));

        products.add(product);
        return product;
    }
}
