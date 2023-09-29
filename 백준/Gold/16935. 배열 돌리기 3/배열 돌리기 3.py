import sys
import queue
input = sys.stdin.readline

n, m, num = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

cals = list(map(int, input().split()))

# 1번 연산
def firstCalc(graph):
    temp = [[0]*m for _ in range(n)]
    for i in range(n):
        temp[i] = graph[n-1-i]
    return temp

# 2번 연산
def secondCalc(graph):
    temp = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            temp[i][j] = graph[i][m-1-j]
    return temp

# 3번 연산
def thirdCalc(graph, n, m):
    temp = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            temp[j][n-1-i] = graph[i][j]
    return temp

# 4번 연산
def fourthCalc(graph, n, m):
    temp = [[0]*n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            temp[m-1-j][i] = graph[i][j]
    return temp

# 5번 연산
def fifthCalc(graph):
    temp = [[0]*m for _ in range(n)]
    for i in range(n//2):
        for j in range(m//2):
            temp[i][j+m//2] = graph[i][j]
    for i in range(n//2):
        for j in range(m//2, m):
            temp[i+n//2][j] = graph[i][j]
    for i in range(n//2, n):
        for j in range(m//2):
            temp[i-n//2][j] = graph[i][j]
    for i in range(n//2, n):
        for j in range(m//2, m):
            temp[i][j-m//2] = graph[i][j]
    return temp

# 6번 연산
def sixthCalc(graph):
    temp = [[0]*m for _ in range(n)]
    for i in range(n//2):
        for j in range(m//2):
            temp[i+n//2][j] = graph[i][j]
    for i in range(n//2):
        for j in range(m//2, m):
            temp[i][j-m//2] = graph[i][j]
    for i in range(n//2, n):
        for j in range(m//2):
            temp[i][j+m//2] = graph[i][j]
    for i in range(n//2, n):
        for j in range(m//2, m):
            temp[i-n//2][j] = graph[i][j]
    return temp

for i in cals:
    n, m = len(graph), len(graph[0])
    if i == 1:
        graph = firstCalc(graph)
    elif i == 2:
        graph = secondCalc(graph)
    elif i == 3:
        graph = thirdCalc(graph, n, m)
    elif i == 4:
        graph = fourthCalc(graph, n, m)
    elif i == 5:
        graph = fifthCalc(graph)
    else:
        graph = sixthCalc(graph)

for i in graph:
    print(*i)
