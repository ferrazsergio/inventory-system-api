package io.github.ferrazsergio.inventorysystem.stockmovement.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import io.github.ferrazsergio.inventorysystem.stockmovement.model.StockMovement;
import io.github.ferrazsergio.inventorysystem.stockmovement.repository.StockMovementRepository;

@Service
public class StockMovementService {

    @Autowired
    private StockMovementRepository stockMovementRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepository.findAll();
    }

    public void deleteStockMovement(Long id) {
        stockMovementRepository.deleteById(id);
    }
    
    public List<Map<String, Object>> getStockMovements() {
        return jdbcTemplate.queryForList("SELECT * FROM stock_movements ORDER BY movement_date DESC");
    }
}

