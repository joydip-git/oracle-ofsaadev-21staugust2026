set serveroutput on;
declare
l_record categories%rowtype;
csys sys_refcursor;
cursor c1 is select c.category_id, c.category_name  from categories c;
type c2 is ref cursor return categories%rowtype;
cat_cursor c2;
BEGIN
open csys for select c.category_id, c.category_name  from categories c;
--open c1;
--open cat_cursor for select c.category_id,c.category_name from categories c;
loop
 fetch csys into l_record;
 exit when csys%notfound;
 dbms_output.put_line(l_record.category_name);
end loop;
close csys;
end;