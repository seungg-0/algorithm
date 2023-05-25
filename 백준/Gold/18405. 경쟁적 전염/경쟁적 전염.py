import sys
input = sys.stdin.readline

n, k = map(int, input().split())
graph = []

for i in range(n):
    tmp = list(map(int, input().split()))
    graph.append(tmp)

s, x, y = map(int, input().split())

dx = [-1 ,1 , 0, 0]
dy = [0, 0, -1, 1]
def bfs(i, j):
    x, y = i, j
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0<= nx < n and 0<= ny < len(graph[0]):
            # 한 번 전파될 때 숫자가 더 낮은 바이러스를 우선적으로 전파시켜주기 위한 조건문
            # 이미 한 번 전파되었고 현재 전파되는 바이러스가 더 작을 경우 현재 바이러스 숫자로 변경
            if graph[nx][ny] != 0 and visited[nx][ny] and (graph[nx][ny] > graph[x][y]):
                graph[nx][ny] = graph[x][y]
                visited[nx][ny] = True
            elif graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y]
                visited[nx][ny] = True

for _ in range(s):
    visited = [[False] * (len(graph[0])) for _ in range(n)]
    for i in range(n):
        for j in range(len(graph[0])):
            if graph[i][j] != 0 and not visited[i][j]:
                bfs(i, j)
    cnt = 0
    for row in graph:
        cnt += row.count(0)
    if cnt == 0:
        break
print(graph[x-1][y-1])
