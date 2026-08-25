set serveroutput on;
DECLARE
    l_value VARCHAR2 :='Hello World';
    l_first NUMBER :=10;
    l_second NUMBER :=0;
    l_result NUMBER;
BEGIN
    dbms_output.put_line(l_value);
    
    l_result := l_first/l_second;
    dbms_output.put_line(l_result);
    
    EXCEPTION WHEN ZERO_DIVIDE THEN
        dbms_output.put_line(SQLERRM);    
    
END;
