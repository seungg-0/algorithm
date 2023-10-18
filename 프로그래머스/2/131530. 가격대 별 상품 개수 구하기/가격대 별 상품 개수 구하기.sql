# 만원 단위의 가격대 별로 상품 개수를 출력
# 가격대 오름차순 정렬

select (case when price < 10000 then 0
        else truncate(price, -4)
        end) as price_group, count(product_id) as products
from product 
group by price_group
order by price_group