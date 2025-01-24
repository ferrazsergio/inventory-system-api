package io.github.ferrazsergio.inventorysystem.product.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ferrazsergio.inventorysystem.category.model.Category;
import io.github.ferrazsergio.inventorysystem.category.repository.CategoryRepository;
import io.github.ferrazsergio.inventorysystem.product.dto.ProductDTO;
import io.github.ferrazsergio.inventorysystem.product.model.Product;
import io.github.ferrazsergio.inventorysystem.product.repository.ProductRepository;
import io.github.ferrazsergio.inventorysystem.supplier.model.Supplier;
import io.github.ferrazsergio.inventorysystem.supplier.repository.SupplierRepository;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product(); // Novo produto
        return productRepository.save(convertDtoToEntity(productDTO, product));
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {
        // Buscar o produto existente
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Atualizar os dados com base no DTO
        return productRepository.save(convertDtoToEntity(productDTO, existingProduct));
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    public BigDecimal calculateTotalStockByCategory(Long categoryId) {
        return productRepository.calculateTotalStockByCategory(categoryId);
    }
    
    private Product convertDtoToEntity(ProductDTO productDTO, Product product) {
        // Buscar a categoria
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Buscar o fornecedor
        Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Mapear os dados do DTO para a entidade
        product.setName(productDTO.getName());
        product.setCategory(category);
        product.setSupplier(supplier);
        product.setQuantity(productDTO.getQuantity());

        return product;
    }

    
}