package com.turkcell.intro.web.repository;

import com.turkcell.intro.web.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository -> ORM Toolunun ilgili nesnenin (tablo) içerisinde işlem yapabilmesini sağlayan nesne.
//@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
}
