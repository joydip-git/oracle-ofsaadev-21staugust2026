create or replace procedure sp_insert_product(
  productname in products.product_name%TYPE,
  price in products.product_price%TYPE,
  proddesc in products.description%TYPE,
  code in products.product_code%TYPE,
  releasedon in products.release_date%TYPE,
  imagedata products.image%TYPE,
  starrating in products.rating%TYPE,
  catid in products.category_id%type
) 
is
begin
    insert into products(product_name,product_code,product_price,description,image,rating,release_date,category_id) 
    values(productname,code,price,proddesc,imagedata,starrating,releasedon,catid);
end;