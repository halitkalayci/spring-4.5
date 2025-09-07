package com.turkcell.intro.web.repository;

import com.turkcell.intro.web.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
