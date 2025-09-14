package com.turkcell.intro.web.service;

import com.turkcell.intro.web.entity.Category;
import com.turkcell.intro.web.repository.CategoryRepository;
import com.turkcell.intro.web.rules.CategoryBusinessRules;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService
{
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;

    public CategoryService(CategoryRepository categoryRepository, CategoryBusinessRules categoryBusinessRules) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    public Optional<Category> findCategoryById(int id)
    {
        return categoryRepository.findById(id);
    }
}
