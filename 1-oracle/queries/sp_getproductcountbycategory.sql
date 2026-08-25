CREATE OR REPLACE PROCEDURE SP_GETPRODUCTCOUNTBYCATEGORY(
 c_data OUT CAT_PRODUCT_CURSOR_RECORD_PKG.c_prod_cat_result
) IS
BEGIN
    open c_data for
    select c.category_name as categoryname,count(p.product_name) as productcount
    from categories c
    left outer join products p on c.category_id=p.category_id
    group by c.category_name;
END;