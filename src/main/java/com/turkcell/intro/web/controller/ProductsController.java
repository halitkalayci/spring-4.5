package com.turkcell.intro.web.controller;

import com.turkcell.intro.web.dto.product.request.CreateProductRequest;
import com.turkcell.intro.web.dto.product.response.CreatedProductResponse;
import com.turkcell.intro.web.entity.Product;
import com.turkcell.intro.web.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Spring tarafından RestController olarak tanınsın.
@RequestMapping("/api/v1/products") // localhost:port/api/v1/products ile başlıyorsa istek buraya gelsin.
public class ProductsController
{
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@RequestBody CreateProductRequest request)
    {
        return productService.add(request);
    }

}
