# Sistema de Gestão de Estoque

Este é um projeto prático para demonstrar o uso do PL/SQL junto com Java Spring em um sistema de gestão de estoque. O sistema permite gerenciar produtos, categorias, fornecedores e movimentação de estoque (entrada e saída), utilizando Oracle Database, Docker e Flyway para facilitar o desenvolvimento.

## Funcionalidades
- **Cadastro de Produtos**: CRUD completo para produtos.
- **Cadastro de Categorias**: CRUD completo para categorias de produtos.
- **Cadastro de Fornecedores**: CRUD completo para fornecedores.
- **Movimentação de Estoque**: Adicionar/remover estoque através de uma procedure PL/SQL.
- **Consultas e Relatórios**:
  - Consulta de estoque.
  - Relatórios de movimentação de estoque gerados por uma function PL/SQL.

## Tecnologias Utilizadas
- **Back-End**:
  - Java 17
  - Spring Boot 3.x
  - Arquitetura MVC
  - Flyway para migração de banco de dados
- **Banco de Dados**:
  - Oracle Database XE (via Docker)
  - PL/SQL para regras de negócio
- **Ferramentas de Desenvolvimento**:
  - Docker e Docker Compose
  - Postman para testar os endpoints

## Estrutura do Banco de Dados

### Tabelas
- **products**: Contém os produtos no estoque.
- **categories**: Contém as categorias dos produtos.
- **suppliers**: Contém informações sobre fornecedores.
- **stock_movements**: Registra entradas e saídas de estoque.

### Regras de Negócio em PL/SQL
- **Procedure**: Para adicionar/remover estoque.
- **Function**: Para calcular o total de itens por categoria.
- **Trigger**: Para registrar movimentações de estoque automaticamente.

## Configuração do Projeto

### Requisitos
Certifique-se de ter as seguintes ferramentas instaladas:
- Docker e Docker Compose
- JDK 17+
- Maven

### Configuração do Banco de Dados
O Docker Compose é utilizado para subir o container do Oracle Database:

```yaml
docker-compose.yml
version: '3.8'

services:
  oracle-server-db:
    image: gvenzl/oracle-xe
    container_name: oracle-server-db
    ports:
      - "1521:1521"
    env_file:
      - ./config/oracle.env
```

### Variáveis de Ambiente
Crie um arquivo `oracle.env` na pasta `config` com as seguintes configurações:

```env
ORACLE_PASSWORD=your_password
ORACLE_DATABASE=your_database
```

### Flyway
As migrações do banco de dados são gerenciadas pelo Flyway. Certifique-se de que os scripts de criação de tabelas e as regras de negócio estejam na pasta `resources/db/migration`.

### Executando o Projeto
1. Suba o container do Oracle Database:
   ```bash
   docker-compose up -d
   ```

2. Compile e execute o projeto Spring Boot:
   ```bash
   mvn spring-boot:run
   ```

3. Utilize o Postman para interagir com os endpoints da API.

## Endpoints da API

### Categories
```java
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
```

### Suppliers
```java
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.saveSupplier(supplier));
    }

    @GetMapping
    public List<Supplier> getSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully");
    }
}
```

### Products
```java
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
```

### Stock Movements
```java
@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {

    @Autowired
    private StockMovementService stockMovementService;

    @PostMapping
    public ResponseEntity<StockMovement> createStockMovement(@RequestBody StockMovement stockMovement) {
        return ResponseEntity.ok(stockMovementService.saveStockMovement(stockMovement));
    }

    @GetMapping
    public List<StockMovement> getStockMovements() {
        return stockMovementService.getAllStockMovements();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStockMovement(@PathVariable Long id) {
        stockMovementService.deleteStockMovement(id);
        return ResponseEntity.ok("Stock movement deleted successfully");
    }
}
```

## Estrutura do Projeto
- **/src/main/java**: Contém o código-fonte Java.
- **/src/main/resources/db/migration**: Scripts de migração do Flyway.
- **docker-compose.yml**: Configuração do Docker Compose.
- **config/oracle.env**: Variáveis de ambiente do Oracle Database.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

