set serveroutput on;
declare
l_stat_record product_statistics_package.product_stat;
begin
    l_stat_record := getProductStat();
    dbms_output.put_line(l_stat_record.max_price||' '||l_stat_record.min_price||' '||l_stat_record.avg_price);
end;
