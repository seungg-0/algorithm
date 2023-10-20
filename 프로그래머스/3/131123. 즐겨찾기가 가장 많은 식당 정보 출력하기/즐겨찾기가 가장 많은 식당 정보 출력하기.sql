select food_type, rest_id, rest_name, favorites
from (select *, rank() over(partition by food_type order by favorites desc) as rk from rest_info) as rest_info_table
where rk = 1
order by food_type desc