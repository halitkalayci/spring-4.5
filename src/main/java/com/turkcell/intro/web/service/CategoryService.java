package com.turkcell.intro.web.service;

import com.turkcell.intro.web.entity.Category;
import com.turkcell.intro.web.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> findCategoryById(int id)
    {
        return categoryRepository.findById(id);
    }
}
