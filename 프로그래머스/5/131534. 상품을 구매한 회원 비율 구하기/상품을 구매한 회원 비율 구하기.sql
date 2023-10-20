select year(sales_date) as year, month(sales_date) as month, count(distinct ui.user_id) as puchased_users, round(count(distinct ui.user_id)/(select count(*) from user_info where year(joined) = '2021'), 1) as puchased_ratio
from user_info as ui
join online_sale as os on ui.user_id = os.user_id
where year(joined) = '2021'
group by year, month
order by year, month