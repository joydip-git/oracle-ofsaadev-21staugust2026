create or replace function addNumbers(
first PLS_INTEGER,
second PLS_INTEGER) return NUMBER
IS
    l_result PLS_INTEGER :=0;

BEGIN
    l_result := first+second;
    return l_result;
END;

set serveroutput on;
declare
    l_add_res PLS_INTEGER :=0;
begin
   l_add_res  := addNumbers(10,20);
   dbms_output.put_line(l_add_res);
end;