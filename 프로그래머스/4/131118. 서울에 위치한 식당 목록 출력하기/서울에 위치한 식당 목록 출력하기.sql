-- 코드를 입력하세요
SELECT A.REST_ID,  A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, ROUND(AVG(B.REVIEW_SCORE),2) AS SCORE
FROM (SELECT * FROM REST_INFO WHERE ADDRESS LIKE '서울%') A
JOIN REST_REVIEW B
ON A.REST_ID = B.REST_ID
GROUP BY B.REST_ID
ORDER BY SCORE DESC, FAVORITES DESC;


# SELECT AVG(REVIEW_SCORE) FROM REST_REVIEW WHERE REST_ID="00001";