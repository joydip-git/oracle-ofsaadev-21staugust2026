create or replace package product_statistics_package is
type product_stat is record(
        max_price products.product_price%type,
        min_price products.product_price%type,
        avg_price products.product_price%type
);
type cursor_prod_stat is ref cursor return product_stat;
END;