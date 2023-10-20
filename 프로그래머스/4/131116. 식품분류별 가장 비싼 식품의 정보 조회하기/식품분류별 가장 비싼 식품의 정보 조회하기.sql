select category, price as max_price, product_name
from (select *, rank() over(partition by category order by price desc) as rk from food_product) as fp
where category in ('과자', '국', '김치', '식용유') and rk = 1
order by price desc

