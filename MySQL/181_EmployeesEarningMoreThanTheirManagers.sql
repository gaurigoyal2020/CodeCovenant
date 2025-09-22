# Write your MySQL query statement below
select e2.name as Employee
from Employee e1
inner join employee e2
on e1.id = e2.managerId 
#e1 is the "manager" because their id is being looked up as someone else’s managerID.
where e1.salary < e2.salary;
