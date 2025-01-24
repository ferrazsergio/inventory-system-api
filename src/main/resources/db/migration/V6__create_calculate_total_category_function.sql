CREATE OR REPLACE FUNCTION calculate_total_category(p_category_id NUMBER)
RETURN NUMBER
IS
    v_total NUMBER(10,2);
BEGIN
    -- Calcula o total de produtos em estoque para a categoria
    SELECT SUM(quantity) INTO v_total
    FROM products
    WHERE category_id = p_category_id;

    RETURN v_total;
END calculate_total_category;
