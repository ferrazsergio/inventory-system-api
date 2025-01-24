CREATE OR REPLACE TRIGGER trg_after_product_update
AFTER UPDATE OF quantity ON products
FOR EACH ROW
DECLARE
    v_movement_type VARCHAR2(10);
    v_quantity_change NUMBER;
BEGIN
    -- Calcula a mudança no estoque
    v_quantity_change := :NEW.quantity - :OLD.quantity;

    -- Determina o tipo de movimentação
    IF v_quantity_change > 0 THEN
        v_movement_type := 'IN';
    ELSIF v_quantity_change < 0 THEN
        v_movement_type := 'OUT';
        v_quantity_change := ABS(v_quantity_change); -- Torna o valor positivo
    ELSE
        -- Sem mudança no estoque, não fazer nada
        RETURN;
    END IF;

    -- Insere a movimentação na tabela stock_movements
    INSERT INTO stock_movements (product_id, movement_type, quantity)
    VALUES (:NEW.id, v_movement_type, v_quantity_change);
END trg_after_product_update;
