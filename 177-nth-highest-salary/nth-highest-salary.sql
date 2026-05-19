CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;

  RETURN (
    WITH cte AS (
        SELECT DISTINCT salary
        FROM Employee
    )
    SELECT salary
    FROM cte
    ORDER BY salary DESC
    LIMIT 1 OFFSET N
  );
END