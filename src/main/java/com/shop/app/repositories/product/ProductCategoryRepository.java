package com.shop.app.repositories.product;

import com.shop.app.entities.products.ProductCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
List<ProductCategory> findAllByEnableIsTrue(Sort sort);


}
