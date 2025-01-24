package io.github.ferrazsergio.inventorysystem.stockmovement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.ferrazsergio.inventorysystem.stockmovement.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

   @Autowired
   private StockService stockService;

   @PostMapping("/update")
   public String updateStock(@RequestParam int productId,
                             @RequestParam int quantity,
                             @RequestParam String movementType) {
       try {
           stockService.updateStock(productId, quantity, movementType);
           return "Stock updated successfully!";
       } catch (Exception e) {
           return "Error updating stock: " + e.getMessage();
       }
   }
   
   @GetMapping("/movements")
   public ResponseEntity<List<Map<String, Object>>> getMovements() {
       return ResponseEntity.ok(stockService.getStockMovements());
   }
}
