package com.shop.app.repositories.product;

import com.shop.app.entities.products.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size,Long> {
}
