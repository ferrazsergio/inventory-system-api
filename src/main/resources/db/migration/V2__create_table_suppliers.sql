-- Criar tabela de fornecedores
CREATE TABLE suppliers (
    id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR2(100) NOT NULL
);