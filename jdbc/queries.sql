/* Count of employees by department */
select d.departmentName, count(*) 
from `jdbc`.Employee e left join `jdbc`.Department d
on e.dept_id = d.id
group by d.departmentName; 

/* Rank employee by salary */
select e.fullName, dense_rank() over (order by e.salary desc) as ranking_by_salary
from `jdbc`.Employee e;

/* Rank employee by salary within a department */
select e.fullName, dense_rank() over (partition by e.dept_id order by e.salary desc) as ranking_by_salary
from `jdbc`.Employee e;

/* Rank employee by salary within a organisation */
select e.fullName, o.orgname, dense_rank() over (partition by eo.org_id order by e.salary desc) as ranking_by_salary
from `jdbc`.Employee e 
join `jdbc`.Employee_Organisation eo 
on e.id = eo.emp_id 
join `jdbc`.Organisation o
on eo.org_id = o.id;

/* Count of employees by organisation */
select o.orgname, count(eo.org_id)
from `jdbc`.Employee_Organisation eo
join `jdbc`.Organisation o
on eo.org_id = o.id
group by o.orgname
having count(eo.org_id) > 1;

/* Employees who have joined more than one org */
select e.fullName
from `jdbc`.Employee_Organisation eo
join `jdbc`.Employee e
on eo.emp_id = e.id
group by e.fullName
having count(eo.emp_id) > 1;

with employee_who_have_worked_for_multiple_organisations as (
	select emp_id
    from `jdbc`.Employee_Organisation eo
    group by emp_id
    having count(emp_id) > 1
)
select e.fullname
from `jdbc`.Employee e
join employee_who_have_worked_for_multiple_organisations eo
where e.id = eo.emp_id;

select e.fullname
from `jdbc`.Employee e
where e.id in (
	select emp_id
    from `jdbc`.Employee_Organisation eo
    group by emp_id
    having count(emp_id) > 1
);

/* employee classification by salary range */
select 
case
when salary < 20 then 'low'
when salary > 20 and salary < 40 then 'medium'
when salary > 40 then 'high'
end as salary_classification,
count(*) as number_of_employees
from `jdbc`.Employee
group by
case
when salary < 20 then 'low'
when salary > 20 and salary < 40 then 'medium'
when salary > 40 then 'high'
end;

/*Employees with Salaries Higher Than Their Departmental Average*/
with average_salary_by_department as (
select e.dept_id, avg(e.salary) as average_salary
from `jdbc`.Employee e
group by e.dept_id
)
select e.fullname, e.salary
from `jdbc`.Employee e
join average_salary_by_department ad
on e.dept_id = ad.dept_id
where e.salary > ad.average_salary;

select sysdate();

select substring(fullname, 1, 4) from `jdbc`.Employee e;

create table `jdbc`.Employee_cpy as select * from `jdbc`.Employee;

insert into `jdbc`.Employee_cpy select * from `jdbc`.Employee;

select * from `jdbc`.Employee where salary between 10 and 15;

select * from `jdbc`.Employee where fullname like 'H%';

select * from `jdbc`.Employee where fullname like '___1';

select * from `jdbc`.Employee where fullname not like '___1';

select * from `jdbc`.Employee where fullname not in ('HR 1', 'IT 1');

/* manager and all the employees reporting to him */
select e.id as mgr_id, e1.id as reporting_emp_id, e1.fullname from `jdbc`.Employee e join `jdbc`.Employee e1 where e1.mgr_id = e.id and e1.mgr_id = 1;

/* next two queries exhibit the cross join/ cartesian product against join*/
select count(*) 
from `jdbc`.Employee e, `jdbc`.Department d
where e.dept_id = d.id;


select count(*) 
from `jdbc`.Employee e
left join `jdbc`.Department d
on e.dept_id = d.id;

/* department-wise count of employees sorted by department’s count in ascending order */
select e.dept_id, count(e.id) as employee_count_by_department 
from `jdbc`.Employee e
group by e.dept_id
order by employee_count_by_department desc;

select rowno from `jdbc`.Employee e; 