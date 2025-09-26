# Write your MySQL query statement below
select distinct teacher_id,COUNT(distinct subject_id) as cnt
from Teacher 
group by teacher_id;