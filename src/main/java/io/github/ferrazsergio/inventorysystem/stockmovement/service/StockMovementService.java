package io.github.ferrazsergio.inventorysystem.stockmovement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ferrazsergio.inventorysystem.stockmovement.model.StockMovement;
import io.github.ferrazsergio.inventorysystem.stockmovement.repository.StockMovementRepository;

@Service
public class StockMovementService {

    @Autowired
    private StockMovementRepository stockMovementRepository;

    public StockMovement saveStockMovement(StockMovement stockMovement) {
        String correctedMovementType = stockMovement.getMovementType().toUpperCase();
        
        if (!correctedMovementType.equals("IN") && !correctedMovementType.equals("OUT")) {
            throw new IllegalArgumentException("Tipo de movimentação inválido.");
        }
        stockMovement.setMovementType(correctedMovementType);
        
        return stockMovementRepository.save(stockMovement);
    }

    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepository.findAll();
    }

    public void deleteStockMovement(Long id) {
        stockMovementRepository.deleteById(id);
    }
}

