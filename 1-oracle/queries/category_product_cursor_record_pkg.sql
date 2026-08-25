CREATE PACKAGE CAT_PRODUCT_CURSOR_RECORD_PKG IS
--creating a record type
type product_category_record is record(
 categoryname categories.category_name%type,
 productcount int
);
type c_prod_cat_result is ref cursor return product_category_record;
END;