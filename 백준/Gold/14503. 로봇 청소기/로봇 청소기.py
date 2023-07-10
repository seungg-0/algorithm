# 14503 로봇 청소기


import sys
input = sys.stdin.readline

row, col = map(int, input().split())
r, c, d = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(row)]

dic = {0: [0, -1], 1: [-1, 0], 2: [0, 1], 3: [1, 0]}
dic_back = {0: [1, 0], 1: [0, -1], 2: [-1, 0], 3: [0, 1]}
#1, 0, 3, 2, 1, 0, 3, 2 반복하며 탐색

graph[r][c] = 2
x, y = r, c
n = d
count = 0
while True:
    dx, dy = dic[n]
    if 0<=(x+dx)<row and 0<=(y+dy)<col and graph[x+dx][y+dy] == 0:
        x, y = x + dx, y + dy
        graph[x][y] = 2
        count = 0
    else:
        count += 1
    if n == 0:
        n = 3
    else:
        n -= 1
    if count == 4:
        dx, dy = dic_back[n]
        if 0<=(x+dx)<row and 0<=(y+dy)<col and (graph[x+dx][y+dy] == 0) or (graph[x+dx][y+dy] == 2):
            count = 0
            x, y = x+dx, y+dy
            graph[x][y] = 2
        else:
            break

answer = 0
for i in range(row):
    answer += graph[i].count(2)

print(answer)

