'''
세로 n 가로 m
BFS로 덩어리별 key, value (EX) A덩어리-8석유) 저장
모든 열 돌면서 0 아니고, set에 key 없으면 dict에서 꺼내서 value 더하기 (key는 set에 저장)
or
석유 덩어리 크기를 계산하고
해당 덩어리가 걸쳐 있는 열을 set에 저장하고
BFS가 끝나면 그 열들에 석유 크기를 바로 더하는 방식이야.
'''
from collections import deque
def solution(land):
    answer = 0
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    n = len(land)
    m = len(land[0])
    col_fuels = [0]*m
    
    for r in range(n):
        for c in range(m):
            if(land[r][c]==1):
                queue = deque([(r, c)])
                fuel = 1
                land[r][c] = -1
                columns = {c} # 파이썬 set 은 중괄호 {}
                while(queue):
                    row, col = queue.popleft()
                    for i in range(4):
                        nr = row+dx[i]
                        nc = col+dy[i]
                        if(0<=nr<n and 0<=nc<m and land[nr][nc]==1):
                            fuel+=1
                            queue.append((nr, nc))
                            land[nr][nc] = -1
                            columns.add(nc)
                for col in columns:
                    col_fuels[col] += fuel
    for fuel in col_fuels:
        answer = max(fuel, answer)
    return answer

