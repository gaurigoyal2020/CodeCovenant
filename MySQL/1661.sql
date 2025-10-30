# Write your MySQL query statement below
select machine_id, round(avg(process_time), 3) as processing_time
from (
    select a.machine_id, a.process_id, b.timestamp - a.timestamp as process_time
    from Activity a
    inner join Activity b
        on a.machine_id = b.machine_id
        and a.process_id = b.process_id
        and a.activity_type = 'start'
        and b.activity_type = 'end'
    ) t
group by machine_id;
