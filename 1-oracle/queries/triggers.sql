CREATE OR REPLACE TRIGGER increase_employee_count_trigger
AFTER INSERT
ON EMPLOYEES
FOR EACH ROW
DECLARE
    l_dept_id int;
BEGIN
l_dept_id := :NEW.department_id;
 UPDATE DEPARTMENTS SET employee_count=employee_count+1 WHERE department_id=l_dept_id;
END;

CREATE OR REPLACE TRIGGER decrease_employee_count_trigger
AFTER DELETE
ON EMPLOYEES
FOR EACH ROW
DECLARE
    l_dept_id int;
BEGIN
l_dept_id := :OLD.department_id;
 UPDATE DEPARTMENTS SET employee_count=employee_count-1 WHERE department_id=l_dept_id;
END;

CREATE OR REPLACE TRIGGER update_employee_count_trigger
AFTER UPDATE
ON EMPLOYEES
FOR EACH ROW
DECLARE
    l_dept_id_old int;
    l_dept_id_new int;
BEGIN
l_dept_id_old := :OLD.department_id;
l_dept_id_new := :NEW.department_id;
 UPDATE DEPARTMENTS SET employee_count=employee_count-1 WHERE department_id=l_dept_id_old;
 UPDATE DEPARTMENTS SET employee_count=employee_count+1 WHERE department_id=l_dept_id_new;
END;


CREATE OR REPLACE TRIGGER employees_department_trigger
AFTER 
INSERT OR UPDATE OR DELETE
ON EMPLOYEES
FOR EACH ROW
DECLARE
BEGIN
    IF INSERTING THEN
       UPDATE DEPARTMENTS SET employee_count=employee_count+1 WHERE department_id=:NEW.department_id;
    ELSIF DELETING THEN
       UPDATE DEPARTMENTS SET employee_count=employee_count-1 WHERE department_id= :OLD.department_id;
    ELSIF UPDATING THEN
      UPDATE DEPARTMENTS SET employee_count=employee_count-1 WHERE department_id= :OLD.department_id;
      UPDATE DEPARTMENTS SET employee_count=employee_count+1 WHERE department_id= :NEW.department_id;
    END IF;
    
END;



