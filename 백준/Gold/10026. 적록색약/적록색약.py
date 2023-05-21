import sys
input = sys.stdin.readline
sys.setrecursionlimit(15000)


n = int(input())
graph = []
for _ in range(n):
    graph.append(list(input().rstrip()))

dx = [-1, 1, 0 , 0]
dy = [0, 0, -1, 1]
answer = []

# 적록색약 x
visited = [[False]*n for _ in range(n)]
def dfs(x, y, color):
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0<= nx < n and 0<= ny < n and not visited[nx][ny]:
            if color == graph[nx][ny]:
                visited[nx][ny] = True
                dfs(nx, ny, color)

count = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visited[i][j] = True
            dfs(i, j, graph[i][j])
            count += 1
answer.append(count)

# 적록색약
visited = [[False]*n for _ in range(n)]
def dfs_RG(x, y, color):
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0<= nx < n and 0<= ny < n and not visited[nx][ny]:
            if color == "R" or color == "G":
                if graph[nx][ny] == "R" or graph[nx][ny] == "G":
                    visited[nx][ny] = True
                    dfs_RG(nx, ny, color)
            else:
                if color == graph[nx][ny]:
                    visited[nx][ny] = True
                    dfs_RG(nx, ny, color)
count = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visited[i][j] = True
            dfs_RG(i, j, graph[i][j])
            count += 1
answer.append(count)

print(*answer, end=" ")