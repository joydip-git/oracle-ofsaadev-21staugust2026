--set serveroutput on;
--declare
----l_cat_name categories.category_name%type;
--l_cat_row categories%rowtype;
--begin
----select c.category_name, c.category_id into l_cat_name from categories c where c.category_id=100;
----dbms_output.put_line(l_cat_name);
--select c.category_id, c.category_name into l_cat_row from categories c where c.category_id=100;
--dbms_output.put_line(l_cat_row.category_id||' '||l_cat_row.category_name);
----dbms_output.put_line(l_cat_row);
--end;

declare
    cursor category_cursor is select c.category_id, c.category_name from categories c;
    l_cat_cursor category_cursor;
    l_cat_id int;
    l_cat_name varchar2;
    
begin
open l_cat_cursor;
loop 
    fetch l_cat_cursor into l_cat_id, l_cat_name;    
    exit when l_cat_cursor%notfound;
    dbms_output.put_line(l_cat_id||' '||l_cat_name);
end loop;

close l_cat_cursor;
end;