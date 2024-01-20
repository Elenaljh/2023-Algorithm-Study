-- 동명 동물 수 찾기
-- 동물 보호소에 들어온 동물 이름 중 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회하는 SQL문을 작성해주세요.
-- 이때 결과는 이름이 없는 동물은 집계에서 제외하며, 결과는 이름 순으로 조회해주세요.
    SELECT NAME, COUNT(NAME) AS COUNT
    FROM ANIMAL_INS
    WHERE NAME IS NOT NULL
    GROUP BY NAME
    HAVING COUNT(NAME) > 1
    ORDER BY NAME;


-- 여러 기준으로 정렬하기
-- 동물 보호소에 들어온 모든 동물의 아이디와 이름, 보호 시작일을 이름 순으로 조회하는 SQL문을 작성해주세요.
-- 단, 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야 합니다.
    SELECT ANIMAL_ID, NAME, DATETIME
    FROM ANIMAL_INS
    ORDER BY NAME, DATETIME DESC;


-- 어린 동물 찾기
-- 동물 보호소에 들어온 동물 중 젊은 동물1의 아이디와 이름을 조회하는 SQL 문을 작성해주세요.
-- 이때 결과는 아이디 순으로 조회해주세요.
    SELECT ANIMAL_ID, NAME
    FROM ANIMAL_INS
    WHERE INTAKE_CONDITION != 'Aged'
    ORDER BY ANIMAL_ID;


-- 상위 한 개 레코드
-- 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회하는 SQL 문을 작성해주세요.
    SELECT NAME
    FROM ANIMAL_INS
    ORDER BY DATETIME
    LIMIT 1;