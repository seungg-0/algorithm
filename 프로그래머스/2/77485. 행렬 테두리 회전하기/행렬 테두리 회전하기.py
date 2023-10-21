# 직사각형 모양의 범위를 여러 번 선택해 테두리 부분에 있는 숫자들 한 칸씩 시계방향 회전 (rotate) - 테두리만
# 각 테두리 회전시키고, 최솟값 answer에 추가

from collections import deque

def solution(rows, columns, queries):
    answer = []
    graph = [[0]*columns for _ in range(rows)]
    cnt = 1
    for i in range(rows):
        for j in range(columns):
            graph[i][j] = cnt
            cnt += 1
            
    def outline(x1, y1, x2, y2):
        queue = deque()
        for i in range(y1-1, y2): # 윗줄
            queue.append(graph[x1-1][i])
        for i in range(x1, x2): # 오른쪽
            queue.append(graph[i][y2-1])
        for i in range(y2-2, y1-2, -1): # 아랫줄
            queue.append(graph[x2-1][i])
        for i in range(x2-2, x1-1, -1): # 왼쪽
            queue.append(graph[i][y1-1])
        return queue
    
    def update(x1, y1, x2, y2, queue):
        for i in range(y1-1, y2): # 윗줄
            graph[x1-1][i] = queue.popleft()
        for i in range(x1, x2): # 오른쪽
            graph[i][y2-1] = queue.popleft()
        for i in range(y2-2, y1-2, -1): # 아랫줄
            graph[x2-1][i] = queue.popleft()
        for i in range(x2-2, x1-1, -1): # 왼쪽
            graph[i][y1-1] = queue.popleft()
            
    for x1, y1, x2, y2 in queries:
        queue = outline(x1, y1, x2, y2)
        queue.rotate(1) # 시계방향으로 한 번 회전
        update(x1, y1, x2, y2, queue)
        queue = outline(x1, y1, x2, y2)
        answer.append(min(queue))       

    return answer