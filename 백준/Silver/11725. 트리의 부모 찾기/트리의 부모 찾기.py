import sys
input = sys.stdin.readline
from collections import deque

# 큐에 서 pop 하는 것은 부모 !

n = int(input())
visited = [False for _ in range(n+1)]
linked = [[] for _ in range(n+1)]

for i in range(n-1):
    a, b = map(int, input().split())
    linked[a].append(b)
    linked[b].append(a)

queue = deque()
queue.append(1)
answer = [[] for _ in range(n+1)]
while queue:
    parent = queue.popleft()
    for i in linked[parent]:
        if not visited[i]:
            visited[i] = True
            queue.append(i)
            answer[i] = parent

for i in range(2, n+1):
    print(answer[i])

