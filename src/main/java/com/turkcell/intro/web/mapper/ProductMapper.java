package com.turkcell.intro.web.mapper;

import com.turkcell.intro.web.dto.product.request.CreateProductRequest;
import com.turkcell.intro.web.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper
{
    // Dışarıdan bu mapper'a erişim için
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product createProductRequestToProduct(CreateProductRequest createProductRequest);
}
