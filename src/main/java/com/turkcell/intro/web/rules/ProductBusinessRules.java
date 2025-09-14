package com.turkcell.intro.web.rules;

import com.turkcell.intro.web.entity.Product;
import com.turkcell.intro.web.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component // IoC'e bu classı bağımlılık olarak ekle.
public class ProductBusinessRules
{
    private final ProductRepository productRepository;

    public ProductBusinessRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void productMustNotExistWithSameName(String name)
    {
        Product productWithSameName = productRepository
                .findTop1ByNameIgnoreCase(name)
                .orElse(null);

        if (productWithSameName != null)
            throw new RuntimeException("Bu isim ile bir ürün zaten bulunmaktadır.");
    }
}
