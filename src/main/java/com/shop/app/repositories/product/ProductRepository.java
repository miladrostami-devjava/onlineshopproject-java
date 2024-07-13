package com.shop.app.repositories.product;

import com.shop.app.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("from Product where category.id =: categoryId")
    List<Product> findAllByCategory(long categoryId);

    @Query("from Product where enable = true and (title like concat('%',:search,'%') or description like concat('%',:search,'%'))")
    List<Product> findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(String search);

}
