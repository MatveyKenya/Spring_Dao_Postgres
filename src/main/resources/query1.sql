/* выборка продуктов для параметра name */
SELECT o.product_name, o.amount
FROM orders o
    INNER JOIN customers c on c.id = o.customer_id
WHERE c.name = ?