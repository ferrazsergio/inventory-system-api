CREATE OR REPLACE PROCEDURE update_stock (
    p_product_id NUMBER,
    p_quantity NUMBER,
    p_movement_type VARCHAR2
) AS
BEGIN
    IF p_movement_type = 'IN' THEN
        UPDATE products
        SET quantity = quantity + p_quantity
        WHERE id = p_product_id;
    ELSIF p_movement_type = 'OUT' THEN
        UPDATE products
        SET quantity = quantity - p_quantity
        WHERE id = p_product_id;
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Tipo de movimentação inválido.');
    END IF;

    INSERT INTO stock_movements (product_id, movement_type, quantity)
    VALUES (p_product_id, p_movement_type, p_quantity);
END;
