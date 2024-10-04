-- 코드를 입력하세요
SELECT B.CATEGORY, SUM(S.SALES) AS TOTAL_SALES
FROM BOOK AS B LEFT OUTER JOIN BOOK_SALES AS S ON B.BOOK_ID = S.BOOK_ID
WHERE YEAR(S.SALES_DATE) = 2022 AND MONTH(S.SALES_DATE) = 1
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY ASC;

