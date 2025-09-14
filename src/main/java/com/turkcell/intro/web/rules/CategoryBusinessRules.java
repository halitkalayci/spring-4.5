package com.turkcell.intro.web.rules;

import com.turkcell.intro.web.core.exception.type.BusinessException;
import com.turkcell.intro.web.entity.Category;
import com.turkcell.intro.web.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryBusinessRules
{
    private final CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category categoryShouldExistWithGivenId(int id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("Category with id " + id + " not found"));
    }

    public void categoryShouldNotExistWithSameName(String name) {
        Category category = categoryRepository.findTop1ByNameIgnoreCase(name).orElse(null);
        if (category != null) {
            throw new BusinessException("Category with name " + name + " already exists");
        }
    }
}
