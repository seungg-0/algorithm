# 가격 젤 비싼 식품 조회
# '과자', '국', '김치', '식용유' 만 추력
# 식품 가격 기준으로 내림차순 정렬

# 오답
# SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE, PRODUCT_NAME
# FROM FOOD_PRODUCT
# WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
# GROUP BY CATEGORY
# ORDER BY MAX_PRICE DESC

# SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
# FROM FOOD_PRODUCT
# WHERE (CATEGORY, PRICE) IN (SELECT CATEGORY, MAX(PRICE) FROM FOOD_PRODUCT WHERE CATEGORY IN ('과자', '국', '김치', '식용유') GROUP BY CATEGORY)
# ORDER BY MAX_PRICE DESC

select category, price as max_price, product_name
from (select *, rank() over (partition by category order by price desc) as rk from food_product) as fp
where fp.rk = 1 and category in ('과자', '국', '김치', '식용유')
order by max_price desc

