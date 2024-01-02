-- 역정렬
-- 동물 보호소에 들어온 모든 동물의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 ANIMAL_ID 역순으로 보여주세요.
-- SQL을 실행하면 다음과 같이 출력되어야 합니다.
    SELECT NAME, DATETIME
    FROM ANIMAL_INS
    ORDER BY ANIMAL_ID DESC;


-- 동물 수 구하기
-- 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.
    SELECT count(*) AS count
    FROM ANIMAL_INS;


-- 이름이 있는 동물의 아이디
-- 동물 보호소에 들어온 동물 중, 이름이 있는 동물의 ID를 조회하는 SQL 문을 작성해주세요. 단, ID는 오름차순 정렬되어야 합니다.
    SELECT ANIMAL_ID
    FROM ANIMAL_INS
    WHERE NAME IS NOT NULL
    ORDER BY ANIMAL_ID;


-- 최소값 구하기
-- 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.
    SELECT MIN(DATETIME) as '시간'
    FROM ANIMAL_INS;


-- 중복 제거
-- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성해주세요.
-- 이때 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 칩니다.
    SELECT COUNT(DISTINCT(NAME)) as 'count'
    FROM ANIMAL_INS
    WHERE NAME IS NOT NULL;
