create or replace function fn_getProductCountForCategories 
return CAT_PRODUCT_CURSOR_RECORD_PKG.c_prod_cat_result
as
   c_data CAT_PRODUCT_CURSOR_RECORD_PKG.c_prod_cat_result;
BEGIN
    open c_data for
    select c.category_name as categoryname,count(p.product_name) as productcount
    from categories c
    left outer join products p on c.category_id=p.category_id
    group by c.category_name;
    
    return c_data;
END;

SET SERVEROUTPUT ON;
DECLARE
r_data CAT_PRODUCT_CURSOR_RECORD_PKG.product_category_record;
c_data CAT_PRODUCT_CURSOR_RECORD_PKG.c_prod_cat_result;
BEGIN
   c_data := fn_getProductCountForCategories() ;
    
    loop
    fetch c_data into r_data;
    exit when c_data%notfound;
    dbms_output.put_line(r_data.categoryname||':'||r_data.productcount);
    end loop;
    close c_data;
END;

