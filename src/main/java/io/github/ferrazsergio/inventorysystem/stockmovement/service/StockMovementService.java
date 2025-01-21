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

    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepository.findAll();
    }

    public void deleteStockMovement(Long id) {
        stockMovementRepository.deleteById(id);
    }
}

