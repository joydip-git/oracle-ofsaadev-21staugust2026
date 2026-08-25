set serveroutput on;
/*
declare
    l_counter number :=0;
begin
  loop
     l_counter := l_counter+1;
        if l_counter>3 then
            exit;
        end if;
        dbms_output.put_line('inside loop: '||l_counter);
  end loop;
  dbms_output.put_line('outside loop: '||l_counter);
end;


declare
    l_counter number :=0;
begin
  loop
     l_counter := l_counter+1;
        exit when l_counter>3;
        dbms_output.put_line('inside loop: '||l_counter);
  end loop;
  dbms_output.put_line('outside loop: '||l_counter);
end;


begin
   for l_counter in 1..5
   loop
    dbms_output.put_line(l_counter);
   end loop;
end;
*/

declare
l_counter number :=0;
begin
  while l_counter <=5
  loop
    dbms_output.put_line(l_counter);
    l_counter := l_counter +1;
  end loop;
end;

