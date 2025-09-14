package com.turkcell.intro.web.repository;

import com.turkcell.intro.web.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findTop1ByNameIgnoreCase(String name);
}
