package io.github.ferrazsergio.inventorysystem.product.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.ferrazsergio.inventorysystem.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT calculate_total_category(:p_category_id) FROM DUAL", nativeQuery = true)
    BigDecimal calculateTotalStockByCategory(@Param("p_category_id") Long categoryId);
}