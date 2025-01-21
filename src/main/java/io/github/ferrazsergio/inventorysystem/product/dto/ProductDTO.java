package io.github.ferrazsergio.inventorysystem.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
    private String name;
    
    @JsonProperty("category_id") // Mapeia o campo "category_id" do JSON para "categoryId"
    private Long categoryId;
    @JsonProperty("supplier_id") // Mapeia o campo "supplier_id" do JSON para "supplierId"
    private Long supplierId;
    private int quantity;
    
    
	public ProductDTO() {
		super();
	}


	public ProductDTO(String name, Long categoryId, Long supplierId, int quantity) {
		super();
		this.name = name;
		this.categoryId = categoryId;
		this.supplierId = supplierId;
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


	public Long getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", quantity="
				+ quantity + "]";
	}
	
}