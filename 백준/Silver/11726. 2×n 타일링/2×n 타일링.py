import sys
input = sys.stdin.readline

graph = [[] for _ in range(1001)]
graph[1] = 1
graph[2] = 2
n = int(input())
for i in range(3, n+1):
    graph[i] = graph[i-1]+graph[i-2]
print(graph[n]%10007)