import sys
input = sys.stdin.readline
from collections import deque

r, c = map(int, input().split())

# 초기 그래프 입력
graph = []
for i in range(r):
    graph.append(list(map(int, input().split(" "))))

# 2인 좌표 찾기
for i in range(r):
    for j in range(c):
        if graph[i][j] == 2:
            r_2, c_2 = i, j
            
graph[r_2][c_2] = 0
visited = [[False]*c for _ in range(r)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
# dfs 탐색
queue = deque()
queue.append([r_2, c_2])
while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0<=nx<r and 0<=ny<c and (not visited[nx][ny]) and graph[nx][ny] == 1:
            visited[nx][ny] = True
            graph[nx][ny] = graph[x][y]+1
            queue.append([nx, ny])

# 원래 갈 수 있는 땅이지만 도달할 수 없는 위치 -1로 변경
for i in range(r):
    for j in range(c):
        if graph[i][j] == 1 and not visited[i][j]:
            graph[i][j] = -1
for i in range(len(graph)):
    print(*graph[i])
