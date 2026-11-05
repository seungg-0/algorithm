'''
직사각형 모양의 범위를 여러 번 선태갷, 테두리 부분에 있는 숫자들 시계방향으로 회전

(x1, y1, x2, y2)
회전 다 하고, 회전에 의해 위치가 바뀐 숫자중 가장 작은 숫자를 배열에 담아 return

step1 1, 2, 3, 4 ~~ 채워넣기 (map)
step2 좌표로 테두리 탐색, 회전 시키기 (최솟값 탐색하며)
* map.copy()보다는 회전할 테두리 숫자를 별도 리스트에 저장한 다음, 회전 결과를 다시 map에 반영하는 방식
* min() 활용
'''


def solution(rows, columns, queries):
    answer = []
    map = [[0] * columns for _ in range(rows)] # [암기] 빈 배열 초기화
    
    n = 1
    for i in range(rows): # 초기화
        for j in range(columns):
            map[i][j] = n
            n += 1
    
    for query in queries:
        x1 = query[0]-1
        y1 = query[1]-1
        x2 = query[2]-1
        y2 = query[3]-1
        
        bak = map[x1][y1]
        minVal = 1e9
        for x in range(x1, x2):
            map[x][y1] = map[x+1][y1]
            minVal = min(minVal, map[x+1][y1])
        for y in range(y1, y2):
            map[x2][y] = map[x2][y+1]
            minVal = min(minVal, map[x2][y+1])
        for x in range(x2, x1, -1):
            map[x][y2] = map[x-1][y2]
            minVal = min(minVal, map[x-1][y2])
        for y in range(y2, y1, -1):
            map[x1][y] = map[x1][y-1]
            minVal = min(minVal, map[x1][y-1])
        map[x1][y1+1] = bak
        minVal = min(minVal, bak)
        answer.append(minVal)
       
    
    return answer