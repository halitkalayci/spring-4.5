package com.turkcell.intro.web.service;

import com.turkcell.intro.web.dto.category.request.CreateCategoryRequest;
import com.turkcell.intro.web.dto.category.request.UpdateCategoryRequest;
import com.turkcell.intro.web.dto.category.response.*;
import com.turkcell.intro.web.entity.Category;
import com.turkcell.intro.web.mapper.CategoryMapper;
import com.turkcell.intro.web.repository.CategoryRepository;
import com.turkcell.intro.web.rules.CategoryBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//16.25

@Service
@Validated
public class CategoryService
{
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryBusinessRules categoryBusinessRules, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRules = categoryBusinessRules;
        this.categoryMapper = categoryMapper;
    }

    public List<GetListCategoryResponse> getList() {
        List<Category> categories = categoryRepository.findAll();

        return categoryMapper.toGetListCategoryResponse(categories);
    }

    public GetByIdCategoryResponse getById(int id) {
       Category category = categoryBusinessRules.categoryShouldExistWithGivenId(id);

       return categoryMapper.toGetByIdCategoryResponse(category);
    }

    public CreatedCategoryResponse add(@Valid CreateCategoryRequest request) {
        categoryBusinessRules.categoryShouldNotExistWithSameName(request.getName());

        Category category = categoryMapper.toCategory(request);
        category = categoryRepository.save(category);

        return categoryMapper.toCreatedCategoryResponse(category);
    }

    public UpdatedCategoryResponse update(@Valid UpdateCategoryRequest request) {
        Category category = categoryBusinessRules.categoryShouldExistWithGivenId(request.getId());
        categoryBusinessRules.categoryShouldNotExistWithSameName(request.getName());

        category = categoryMapper.toCategory(request);
        category = categoryRepository.save(category);

        return categoryMapper.toUpdatedCategoryResponse(category);
    }

    public DeletedCategoryResponse delete(int id) {
        Category category = categoryBusinessRules.categoryShouldExistWithGivenId(id);
        categoryRepository.delete(category);
        return categoryMapper.toDeletedCategoryResponse(category);
    }
}
