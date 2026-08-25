SET SERVEROUTPUT ON;
DECLARE
 l_product_record products%rowtype;
BEGIN
select *
into l_product_record
from products
where product_id=1;

dbms_output.put_line(l_product_record.product_name);
END;

