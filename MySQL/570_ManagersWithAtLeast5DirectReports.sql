# Write your MySQL query statement below
select e1.name
from Employee e1
join Employee e2
on e1.id = e2.managerId
group by e1.id
having count(*) >= 5;

#OR
select e1.name
from Employee e1
join (
    select managerId
    from Employee
    group by managerId
    having count(*) >= 5
)e2
on e1.id = e2.managerId;
