-- 동물의 아이디와 이름
-- 동물 보호소에 들어온 모든 동물의 아이디와 이름을 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요. SQL을 실행하면 다음과 같이 출력되어야 합니다.
  SELECT ANIMAL_ID, NAME
  FROM ANIMAL_INS
  ORDER BY ANIMAL_ID;


-- 아픈 동물 찾기
-- 동물 보호소에 들어온 동물 중 아픈 동물1의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과는 아이디 순으로 조회해주세요.
  SELECT ANIMAL_ID, NAME
  FROM ANIMAL_INS
  WHERE INTAKE_CONDITION = 'Sick'
  ORDER BY ANIMAL_ID;