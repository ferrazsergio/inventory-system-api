-- Criar tabela de produtos
CREATE TABLE products (
    id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    category_id NUMBER REFERENCES categories(id),
    supplier_id NUMBER REFERENCES suppliers(id),
    quantity NUMBER DEFAULT 0
);