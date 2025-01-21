package io.github.ferrazsergio.inventorysystem.stockmovement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ferrazsergio.inventorysystem.stockmovement.model.StockMovement;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
}
