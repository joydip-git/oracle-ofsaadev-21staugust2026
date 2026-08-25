declare 
l_cat_name varchar2 :='book';
begin
 sp_insert_category(l_cat_name);
end;

 select * from categories;
 
declare
begin
select c.category_id, c.category_name from categories c;
end;

DECLARE
current_date date;
begin
select cast(sysdate as date) into current_date from dual;
sp_insert_product('One plus 7',50000.00,'new mobile from one plus','op-1324', current_date,null,4,101);
end;

select * from products;



select c.category_name,count(p.product_name) from categories c
left outer join products p on c.category_id=p.category_id
group by c.category_name;