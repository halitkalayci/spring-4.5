package com.turkcell.intro.web.repository;

import com.turkcell.intro.web.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// JpaRepository -> ORM Toolunun ilgili nesnenin (tablo) içerisinde işlem yapabilmesini sağlayan nesne.
//@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

    // Derived Query Methods
    // Select * from products where name LIKE '{name}'
    List<Product> findByNameLikeIgnoreCase(String name); // Derived Query

    // native query false: JPQL
    // native query true: SAF SQL
    @Query(value="Select p from Product p Where LOWER(p.name) LIKE LOWER(:name)", nativeQuery = false) // NativeQuery  -> SAF SQL - JPA+SQL JPQL
    List<Product> search(String name); // Derived Query DEĞİL!

    @Query(value="Select * from products where LOWER(name) LIKE LOWER(:name)", nativeQuery = true) // NativeQuery  -> SAF SQL - JPA+SQL JPQL
    List<Product> searchSql(String name); // Derived Query DEĞİL!

    // Optional -> Sonuç Bulunmayabilir?
    Optional<Product> findTop1ByNameIgnoreCase(String name);
}
