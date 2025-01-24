package io.github.ferrazsergio.inventorysystem.stockmovement.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import io.github.ferrazsergio.inventorysystem.stockmovement.repository.StockRepository;

@Service
public class StockService {

   @Autowired
   private StockRepository stockRepository;
   @Autowired
   JdbcTemplate jdbcTemplate;
   public void updateStock(int productId, int quantity, String movementType) {
	    String correctedMovementType = movementType.toUpperCase();
       
       if (!correctedMovementType.equals("IN") && !correctedMovementType.equals("OUT")) {
           throw new IllegalArgumentException("Tipo de movimentação inválido.");
       }
       stockRepository.updateStock(productId, quantity, movementType);
   }
   
   public List<Map<String, Object>> getStockMovements() {
       return jdbcTemplate.queryForList("SELECT * FROM stock_movements ORDER BY movement_date DESC");
   }
}