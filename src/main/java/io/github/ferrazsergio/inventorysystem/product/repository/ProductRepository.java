package io.github.ferrazsergio.inventorysystem.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ferrazsergio.inventorysystem.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}