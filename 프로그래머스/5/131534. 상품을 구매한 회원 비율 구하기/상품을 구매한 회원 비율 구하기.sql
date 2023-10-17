# 2021년에 가입한 전체 회원들 중 상품 구매한 회원수와 상품 구매한 회원의 비율
# 년, 월별로 출력
# 상품 구매한 회원의 비율 소수점 두번째 자리에서 반올림, 전체 결과는 년을 기준으로 오름차순 정렬, 월 기준으로 오름차순

# 오답 풀이
# SELECT YEAR(JOINED) AS YEAR, MONTH(JOINED) AS MONTH, COUNT(DISTINCT OS.USER_ID) AS PURCHASED_USERS, ROUND(COUNT(DISTINCT OS.USER_ID) / COUNT(UI.USER_ID), 1) AS PURCHASED_RATIO
# FROM USER_INFO AS UI, ONLINE_SALE AS OS
# WHERE YEAR(UI.JOINED)=2021 AND YEAR(UI.JOINED) = YEAR(OS.SALES_DATE) AND MONTH(UI.JOINED) = MONTH(OS.SALES_DATE)
# GROUP BY YEAR, MONTH
# ORDER BY YEAR, MONTH


SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, COUNT(DISTINCT OS.USER_ID) AS PURCHASED_USERS, ROUND(COUNT(DISTINCT OS.USER_ID) / (SELECT COUNT(USER_ID) FROM USER_INFO WHERE YEAR(JOINED) = 2021), 1) AS PURCHASED_RATIO
FROM ONLINE_SALE AS OS
WHERE USER_ID IN (SELECT USER_ID FROM USER_INFO WHERE YEAR(JOINED)=2021)
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH