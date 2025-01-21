package io.github.ferrazsergio.inventorysystem.product.service;

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
    	 System.out.println("ProductDTO: " + productDTO);
    	    System.out.println("CategoryId: " + productDTO.getCategoryId());
    	    System.out.println("SupplierId: " + productDTO.getSupplierId());
    	    System.out.println("Name: " + productDTO.getName());
    	    System.out.println("Quantity: " + productDTO.getQuantity());
    	    
        // Buscar a categoria
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Buscar o fornecedor
        Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Criar e salvar o produto
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCategory(category);
        product.setSupplier(supplier);
        product.setQuantity(productDTO.getQuantity());

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}