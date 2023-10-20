# 자동차 종류가 '트럭'인 자동차의 대여 기록에 대해 대여 기록 별로 대여 금액


select history_id, (case when rent_days >= 90 then floor(daily_fee*rent_days*(85/100))
                   when rent_days >= 30 then floor(daily_fee*rent_days*(92/100))
                    when rent_days >= 7 then floor(daily_fee*rent_days*(95/100))
                   else daily_fee*rent_days end )as fee
from CAR_RENTAL_COMPANY_CAR as crcc
join (select car_id, history_id, datediff(end_date, start_date)+1 as rent_days from CAR_RENTAL_COMPANY_RENTAL_HISTORY) as ccrh
on crcc.car_id = ccrh.car_id
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as crcdp
on crcc.car_type = crcdp.car_type
where crcc.car_type = '트럭'
group by history_id
order by fee desc, history_id desc

# select * from 
# CAR_RENTAL_COMPANY_DISCOUNT_PLAN