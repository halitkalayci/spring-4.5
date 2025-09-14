package com.turkcell.intro.web.controller;

import com.turkcell.intro.web.dto.category.request.CreateCategoryRequest;
import com.turkcell.intro.web.dto.category.request.UpdateCategoryRequest;
import com.turkcell.intro.web.dto.category.response.*;
import com.turkcell.intro.web.entity.Category;
import com.turkcell.intro.web.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController
{
    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<GetListCategoryResponse> getList()
    {
        return categoryService.getList();
    }
    @GetMapping("{id}")
    public GetByIdCategoryResponse getById(@PathVariable  int id){
        return categoryService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCategoryResponse add(@Valid @RequestBody CreateCategoryRequest request){
        return categoryService.add(request);
    }
    @PutMapping
    public UpdatedCategoryResponse update(@Valid @RequestBody UpdateCategoryRequest request){
        return categoryService.update(request);
    }
    @DeleteMapping("{id}")
    public DeletedCategoryResponse delete(@PathVariable  int id)
    {
        return categoryService.delete(id);
    }
}
