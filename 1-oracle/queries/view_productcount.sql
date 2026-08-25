create or replace view categorywiseproductcount
as  select c.category_name as categoryname, count(p.product_name) as productcount
    from categories c
    left outer join products p on c.category_id=p.category_id
    group by c.category_name;
    
    select * from categorywiseproductcount;
    
    create or replace view productview
    as select products.product_name, products.product_price, products.product_code, products.category_id from products;
    
    select * from productview;
    select * from products;
    
    insert into productview(product_name, product_price, product_code, category_id) values('sample',1000.00,'sample-1324',100);