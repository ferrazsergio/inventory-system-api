package io.github.ferrazsergio.inventorysystem.stockmovement.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.github.ferrazsergio.inventorysystem.stockmovement.model.StockMovement;

public interface StockRepository extends CrudRepository<StockMovement, Long> {

    @Procedure(procedureName = "update_stock")
    void updateStock(@Param("p_product_id") int productId,
                     @Param("p_quantity") int quantity,
                     @Param("p_movement_type") String movementType);
}