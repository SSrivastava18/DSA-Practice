# Write your MySQL query statement below
SELECT s.year, p.product_name, s.price 
FROM Sales s 
LEFT JOIN Product p
ON p.product_id = s.product_id;