package com.turkcell.intro.web.repository;

import com.turkcell.intro.web.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository -> ORM Toolunun ilgili nesnenin (tablo) içerisinde işlem yapabilmesini sağlayan nesne.
//@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

    // Derived Query Methods
    // Select * from products where name LIKE '{name}'
    List<Product> findByNameLike(String name);
}
