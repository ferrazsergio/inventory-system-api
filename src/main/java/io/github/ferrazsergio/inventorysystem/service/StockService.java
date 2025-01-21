package io.github.ferrazsergio.inventorysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateStock(Long productId, int quantity, String movementType) {
        //movementType = movementType.toUpperCase();  // Garantir que o tipo seja em maiúsculas
        jdbcTemplate.update("{call update_stock(?, ?, ?)}", productId, quantity, movementType);
    }
}
