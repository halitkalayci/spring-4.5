package com.turkcell.intro.web.mapper;

import com.turkcell.intro.web.dto.category.request.CreateCategoryRequest;
import com.turkcell.intro.web.dto.category.request.UpdateCategoryRequest;
import com.turkcell.intro.web.dto.category.response.*;
import com.turkcell.intro.web.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper
{
    List<GetListCategoryResponse> toGetListCategoryResponse(List<Category> categoryList);

    GetByIdCategoryResponse toGetByIdCategoryResponse(Category category);

    Category toCategory(CreateCategoryRequest createCategoryRequest);

    //@Mapping(target="id", ignore = true)
    Category toCategory(UpdateCategoryRequest updateCategoryRequest);

    CreatedCategoryResponse toCreatedCategoryResponse(Category category);
    UpdatedCategoryResponse toUpdatedCategoryResponse(Category category);
    DeletedCategoryResponse toDeletedCategoryResponse(Category category);
}
