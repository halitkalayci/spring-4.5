package com.turkcell.intro.web.service;

import com.turkcell.intro.web.dto.product.request.CreateProductRequest;
import com.turkcell.intro.web.dto.product.response.CreatedProductResponse;
import com.turkcell.intro.web.entity.Category;
import com.turkcell.intro.web.entity.Product;
import com.turkcell.intro.web.repository.CategoryRepository;
import com.turkcell.intro.web.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // IoC'e bean olarak ekle.
public class ProductService
{
    // final => yalnızca constructor üzerinden set edilebilir.
    private final ProductRepository productRepository;
    // private final CategoryRepository categoryRepository; yanlış kullanım!

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public CreatedProductResponse add(CreateProductRequest createProductRequest)
    {
        /// ....
        Product product = new Product();

        product.setName(createProductRequest.getName());
        product.setUnitPrice(createProductRequest.getUnitPrice());
        product.setStock(createProductRequest.getStock());
        product.setDescription(createProductRequest.getDescription());

        //TODO: Fix
        Category category = new Category();
        category.setId(createProductRequest.getCategoryId());
        product.setCategory(category);
        //
        product = productRepository.save(product);

        return new CreatedProductResponse(product.getId(), product.getName(), product.getStock(), product.getDescription(), product.getUnitPrice());
    }
}
