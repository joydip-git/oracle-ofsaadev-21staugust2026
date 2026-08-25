create or replace function getProductStat
return product_statistics_package.product_stat
as
   c_data product_statistics_package.cursor_prod_stat;
   l_data product_statistics_package.product_stat;
BEGIN
    open c_data for
    select max(products.product_price) as max_price, min(products.product_price) as min_price, avg(products.product_price) as avg_price from products;
    
    loop
     fetch c_data into l_data;
     exit when c_data%notfound;
    end loop;
    
    close c_data;
    return l_data;
END;