declare
    l_cat_cursor SYS_REFCURSOR;
    l_cat_id int;
    l_cat_name varchar2;
    
begin
open l_cat_cursor for select c.category_id, c.category_name from categories c;

loop 
    fetch l_cat_cursor into l_cat_id, l_cat_name;    
    exit when l_cat_cursor%notfound;
    dbms_output.put_line(l_cat_id||' '||l_cat_name);
end loop;

close l_cat_cursor;
end;