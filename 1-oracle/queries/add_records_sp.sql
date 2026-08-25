create or replace procedure sp_insert_category(
  categoryname in varchar2
) 
is
begin
    insert into categories(category_name) values(categoryname);
end;