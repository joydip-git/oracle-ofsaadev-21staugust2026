SET SERVEROUTPUT ON;
DECLARE
--creating a record type
type product_category_record is record(
 categoryname categories.category_name%type,
 productcount int
);
type c_prod_cat_result is ref cursor return product_category_record;
--declare a vaiable of record type
r_data product_category_record;
c_data c_prod_cat_result;
BEGIN
    open c_data for
    select c.category_name as categoryname,count(p.product_name) as productcount
    from categories c
    left outer join products p on c.category_id=p.category_id
    group by c.category_name;
    
    loop
    fetch c_data into r_data;
    exit when c_data%notfound;
    dbms_output.put_line(r_data.categoryname||':'||r_data.productcount);
    end loop;
    close c_data;

END;