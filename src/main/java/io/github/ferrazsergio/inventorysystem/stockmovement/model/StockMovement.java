package io.github.ferrazsergio.inventorysystem.stockmovement.model;

import java.util.Date;

import io.github.ferrazsergio.inventorysystem.product.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_movements")
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private String movementType;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Date movementDate = new Date();
    
	public StockMovement() {
		super();
	}

	public StockMovement(Long id, Product product, String movementType, int quantity, Date movementDate) {
		super();
		this.id = id;
		this.product = product;
		this.movementType = movementType;
		this.quantity = quantity;
		this.movementDate = movementDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

    // Getters and setters
    
    
}