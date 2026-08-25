create or replace view categoryproductview
as  select c.category_name, p.product_name, p.product_code, p.product_price, p.rating, p.category_id,
p.image, p.description
    from categories c
    inner join products p on c.category_id=p.category_id
    order by c.category_name;