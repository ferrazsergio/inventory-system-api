package io.github.ferrazsergio.inventorysystem.stockmovement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ferrazsergio.inventorysystem.stockmovement.model.StockMovement;
import io.github.ferrazsergio.inventorysystem.stockmovement.service.StockMovementService;

@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {

    @Autowired
    private StockMovementService stockMovementService;

    @GetMapping
    public List<StockMovement> getStockMovements() {
        return stockMovementService.getAllStockMovements();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStockMovement(@PathVariable Long id) {
        stockMovementService.deleteStockMovement(id);
        return ResponseEntity.ok("Stock movement deleted successfully");
    }
    

}