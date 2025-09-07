package com.turkcell.intro.web.service;

import com.turkcell.intro.web.dto.product.ProductForAddDto;
import com.turkcell.intro.web.entity.Category;
import com.turkcell.intro.web.entity.Product;
import com.turkcell.intro.web.repository.ProductRepository;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // IoC'e bean olarak ekle.
public class ProductService
{
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product add(ProductForAddDto productForAddDto)
    {
        // Mapping
        Product product = new Product();
        product.setName(productForAddDto.getName());
        product.setDescription(productForAddDto.getDescription());
        product.setStock(productForAddDto.getStock());
        product.setUnitPrice(productForAddDto.getUnitPrice());

        Category category = new Category();
        category.setId(productForAddDto.getCategoryId());

        product.setCategory(category);

        return this.productRepository.save(product);
    }
}
