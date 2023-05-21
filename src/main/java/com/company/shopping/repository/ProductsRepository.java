package com.company.shopping.repository;

import com.company.shopping.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query("Select p from Products p Where p.name = ?1")
    public Optional<Products> getProductByName(String name);
}
