SELECT 
    MCDP_CD AS "진료과 코드", 
    COUNT(*) AS "5월예약건수" -- 또는 COUNT(APNT_NO)
FROM APPOINTMENT
WHERE APNT_YMD LIKE '2022-05%' -- 5월 예약만 필터링
GROUP BY MCDP_CD               -- 진료과별로 뭉치기
ORDER BY COUNT(*) ASC, MCDP_CD ASC; -- 예약건수 적은 순, 코드 사전 순