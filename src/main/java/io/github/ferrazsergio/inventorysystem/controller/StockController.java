package io.github.ferrazsergio.inventorysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.ferrazsergio.inventorysystem.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/movement")
    public ResponseEntity<String> makeMovement(
        @RequestParam Long productId,
        @RequestParam int quantity,
        @RequestParam String type) {
        type = type.toUpperCase();
        stockService.updateStock(productId, quantity, type);
        return ResponseEntity.ok("Movimentação realizada com sucesso!");
    }
}
