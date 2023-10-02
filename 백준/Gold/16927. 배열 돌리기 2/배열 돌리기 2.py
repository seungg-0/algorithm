#16927
# 아이디어 : 껍데기를 한줄로 만들어서 회전 수 만틈 rotate

import sys
input = sys.stdin.readline
from collections import deque

r, c, turn_num = map(int, input().split())
graph = []
for i in range(r):
    graph.append(list(map(int, input().split())))

for i in range(min(r, c)//2):
    outer_line = deque()

    # 껍데기 한줄로 만들기
    col_idx = i # 위
    for _ in range(c-i*2):
        outer_line.append(graph[i][col_idx])
        col_idx += 1
    for k in range(i+1, r-1-i): # 오른쪽
        outer_line.append(graph[k][c-1-i])
    col_idx = c - 1 - i # 아래
    for _ in range(c-i*2):
        outer_line.append(graph[r-1-i][col_idx])
        col_idx -= 1
    for k in range(r-2-i, 0+i, -1): # 왼쪽
        outer_line.append(graph[k][i])

    outer_line.rotate(-turn_num) # 회전 시키기

    # 회전한 값으로 graph에 바꿔넣기
    col_idx = i # 위
    for _ in range(c-i*2):
        graph[i][col_idx] = outer_line.popleft()
        col_idx += 1
    for k in range(i+1, r-1-i): # 오른쪽
        graph[k][c-1-i] = outer_line.popleft()
    col_idx = c - 1 - i # 아래
    for _ in range(c-i*2):
        graph[r-1-i][col_idx] = outer_line.popleft()
        col_idx -= 1
    for k in range(r-2-i, 0+i, -1): # 왼쪽
        graph[k][i] = outer_line.popleft()

for num in graph:
    print(*num)


