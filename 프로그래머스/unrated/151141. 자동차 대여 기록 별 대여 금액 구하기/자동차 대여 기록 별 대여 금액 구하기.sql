-- 1. 오라클 JOIN
SELECT AA.HISTORY_ID
       -- CASE WHEN 썼었다가 NVL 보고 코드가 더 깔끔해서 고침(남의 코드 참고)
     , (AA.DAILY_FEE * AA.DURATION * (1 - NVL(C.DISCOUNT_RATE, 0) * 0.01)) AS FEE
  FROM (SELECT A.CAR_ID
             , A.CAR_TYPE
             , A.DAILY_FEE
             , B.HISTORY_ID
               -- 당일 반납이면 0일이 아니라 1일이 나와야 함
             , (B.END_DATE - B.START_DATE + 1) AS DURATION
               -- 7일 이상부터 조건을 시작하면 30일 이상이 먼저 걸러져서 BETWEEN을 써야했음
               -- 조건 잘 설정하면 깔끔하게 됨(남의 코드 참고)
             , (CASE
                 WHEN (B.END_DATE - B.START_DATE + 1) >= 90
                 THEN '90일 이상'
                 WHEN (B.END_DATE - B.START_DATE + 1) >= 30
                 THEN '30일 이상'
                 WHEN (B.END_DATE - B.START_DATE + 1) >= 7
                 THEN '7일 이상'
                 ELSE ''
               END) AS FILTER
          FROM CAR_RENTAL_COMPANY_CAR A
             , CAR_RENTAL_COMPANY_RENTAL_HISTORY B
         WHERE A.CAR_ID = B.CAR_ID
           AND A.CAR_TYPE = '트럭') AA
             , CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
         WHERE AA.CAR_TYPE = C.CAR_TYPE(+)
               -- 아래 조건도 아우터 조인이어야 값이 제대로 나옴(남의 코드 참고)
           AND AA.FILTER = C.DURATION_TYPE(+)
ORDER BY FEE DESC, HISTORY_ID DESC
           
-- 2. ANSI JOIN
-- SELECT AA.HISTORY_ID
--      , (AA.DAILY_FEE * AA.DURATION * (1 - NVL(C.DISCOUNT_RATE, 0) * 0.01)) AS FEE 
--   FROM (SELECT A.CAR_ID
--              , A.CAR_TYPE
--              , A.DAILY_FEE
--              , B.HISTORY_ID
--              , (B.END_DATE - B.START_DATE + 1) AS DURATION
--              , (CASE
--                  WHEN (B.END_DATE - B.START_DATE + 1) >= 90
--                  THEN '90일 이상'
--                  WHEN (B.END_DATE - B.START_DATE + 1) >= 30
--                  THEN '30일 이상'
--                  WHEN (B.END_DATE - B.START_DATE + 1) >= 7
--                  THEN '7일 이상'
--                  ELSE ''
--                END) AS FILTER
--           FROM CAR_RENTAL_COMPANY_CAR A
--             INNER JOIN
--                CAR_RENTAL_COMPANY_RENTAL_HISTORY B
--             ON A.CAR_ID = B.CAR_ID
--            AND A.CAR_TYPE = '트럭') AA
--             LEFT JOIN
--                CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
--             ON AA.CAR_TYPE = C.CAR_TYPE
--                -- ANSI는 ON을 2번 못쓰니까 알아서 걸러주네
--            AND AA.FILTER = C.DURATION_TYPE
-- ORDER BY FEE DESC, HISTORY_ID DESC