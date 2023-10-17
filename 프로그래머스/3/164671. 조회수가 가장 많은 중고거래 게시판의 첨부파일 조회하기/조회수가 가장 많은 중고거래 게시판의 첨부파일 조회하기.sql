# USED_GOODS_FILE 테이블에서 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로 조회
# FILE_ID기준 내림차순
# 기본적인 파일경로 /home/grep/src/

# 게시글 ID로 조인

SELECT CONCAT("/home/grep/src/", UGF.BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE AS UGF
JOIN (SELECT BOARD_ID FROM USED_GOODS_BOARD ORDER BY VIEWS DESC LIMIT 1) AS UGB
ON UGF.BOARD_ID = UGB.BOARD_ID
ORDER BY FILE_ID DESC





