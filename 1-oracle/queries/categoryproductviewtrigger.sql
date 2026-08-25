create or replace trigger categoryproductviewtrigger
instead of insert on categoryproductview
for each row
declare
   l_cat_id int;
   current_date date;
begin
insert into categories(category_name) values(:NEW.category_name) returning category_id into l_cat_id;

select cast(sysdate as date) into current_date from dual;
sp_insert_product(:NEW.product_name, :new.product_price, :new.description, :new.product_code, current_date,null,:new.rating,l_cat_id);
end;