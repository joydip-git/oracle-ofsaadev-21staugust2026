SET SERVEROUTPUT ON;
DECLARE
r_data CAT_PRODUCT_CURSOR_RECORD_PKG.product_category_record;
c_data CAT_PRODUCT_CURSOR_RECORD_PKG.c_prod_cat_result;
BEGIN
    SP_GETPRODUCTCOUNTBYCATEGORY(c_data) ;
    
    loop
    fetch c_data into r_data;
    exit when c_data%notfound;
    dbms_output.put_line(r_data.categoryname||':'||r_data.productcount);
    end loop;
    close c_data;

END;