package io.github.ferrazsergio.inventorysystem.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ferrazsergio.inventorysystem.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}