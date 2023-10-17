# 보호소에 들어올 당시엔 중성화 되지 않았지만, 보호소 나갈땐 중성화 된 동물의 아이디, 생물종, 이름 조회
# 아이디 순으로 조회

SELECT AI.ANIMAL_ID, AI.ANIMAL_TYPE, AI.NAME
FROM ANIMAL_INS AS AI
JOIN ANIMAL_OUTS AS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.SEX_UPON_INTAKE IN ("Intact Male", "Intact Female")
AND AO.SEX_UPON_OUTCOME IN ("Neutered Male", "Spayed Female")
ORDER BY AI.ANIMAL_ID