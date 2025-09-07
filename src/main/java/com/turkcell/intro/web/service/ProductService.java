package com.turkcell.intro.web.service;

import com.turkcell.intro.web.entity.Product;
import com.turkcell.intro.web.repository.ProductRepository;
import org.hibernate.procedure.ProcedureOutputs;

import java.util.List;

public class ProductService
{
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product add(Product product)
    {
        return product;
    }
}
