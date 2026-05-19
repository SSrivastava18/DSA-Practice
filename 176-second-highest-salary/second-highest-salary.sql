# Write your MySQL query statement below
with cte as(
    select distinct salary from Employee 
) select (
    select salary from cte 
    order by salary desc limit 1 offset 1
)as SecondHighestSalary 