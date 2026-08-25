SET SERVEROUTPUT ON;
DECLARE
--creating a record type
type product_category_record is record(
 categoryname categories.category_name%type,
 productcount int
);

--declare a vaiable of record type
r_data product_category_record;
BEGIN
    select c.category_name,count(p.product_name) 
    into r_data
    from categories c
    left outer join products p on c.category_id=p.category_id
    where c.category_id=100
    group by c.category_name;

    dbms_output.put_line(r_data.categoryname||':'||r_data.productcount);

END;