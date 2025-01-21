package io.github.ferrazsergio.inventorysystem.stockmovement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ferrazsergio.inventorysystem.stockmovement.repository.StockRepository;

@Service
public class StockService {

   @Autowired
   private StockRepository stockRepository;

   public void updateStock(int productId, int quantity, String movementType) {
       stockRepository.updateStock(productId, quantity, movementType);
   }
}