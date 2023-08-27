-- 가격이 제일 비싼 식품의 정보 출력하기

-- 문제 설명
-- 다음은 식품의 정보를 담은 FOOD_PRODUCT 테이블입니다.
-- FOOD_PRODUCT 테이블은 다음과 같으며 PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE는
-- 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 의미합니다.
-- 문제

-- FOOD_PRODUCT 테이블에서 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회하는 SQL문을 작성해주세요.

SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
FROM FOOD_PRODUCT
ORDER BY PRICE DESC
    LIMIT 1;
