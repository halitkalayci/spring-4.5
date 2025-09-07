package com.turkcell.intro.web.service;

import com.turkcell.intro.web.dto.product.request.CreateProductRequest;
import com.turkcell.intro.web.dto.product.response.CreatedProductResponse;
import com.turkcell.intro.web.entity.Category;
import com.turkcell.intro.web.entity.Product;
import com.turkcell.intro.web.repository.CategoryRepository;
import com.turkcell.intro.web.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
@Service // IoC'e bean olarak ekle.
public class ProductService
{
    // final => yalnızca constructor üzerinden set edilebilir.
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    // private final CategoryRepository categoryRepository; yanlış kullanım!
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public CreatedProductResponse add(CreateProductRequest createProductRequest)
    {
        /// ....
        Product product = new Product();

        product.setName(createProductRequest.getName());
        product.setUnitPrice(createProductRequest.getUnitPrice());
        product.setStock(createProductRequest.getStock());
        product.setDescription(createProductRequest.getDescription());

        Category category = categoryService
                .findCategoryById(createProductRequest.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Bu id ile bir kategori bulunamadı."));
        product.setCategory(category);
        product = productRepository.save(product);

        return new CreatedProductResponse(product.getId(),
                product.getName(),
                product.getStock(),
                product.getDescription(),
                product.getUnitPrice(),
                category.getName());
    }
}
