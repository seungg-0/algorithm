import sys
input = sys.stdin.readline
from collections import deque

row, col, n = map(int, input().split(' '))
graph = [[0]*(col) for _ in range(row)]

for _ in range(n):
    x1, y1, x2, y2 = map(int, input().split(' '))
    for i in range(row-y2, row-y1):
        for j in range(x1, x2):
            graph[i][j] = 1

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

queue = deque()
def bfs(i, j, cnt):
    queue.append((i, j))
    count = cnt
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < row and 0 <= ny < col:
                if graph[nx][ny] == 0:
                    graph[nx][ny] = 1
                    queue.append((nx, ny))
                    count += 1
    return count
answer = []
for i in range(row):
    for j in range(col):
        if graph[i][j] == 0:
            graph[i][j] = 1
            cnt = 1
            tmp = bfs(i, j, cnt)
            answer.append(tmp)

answer.sort()
print(len(answer))
print(*answer)


