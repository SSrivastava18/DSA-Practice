# Write your MySQL query statement below
WITH ManagerCount AS (
    SELECT 
        managerId,
        COUNT(*) AS total_reports
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
)

SELECT e.name
FROM Employee e
JOIN ManagerCount m
ON e.id = m.managerId;