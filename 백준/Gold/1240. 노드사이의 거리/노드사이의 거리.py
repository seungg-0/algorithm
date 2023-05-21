import sys
input = sys.stdin.readline
from collections import deque

nodes, n = map(int, input().split())
# graph에 저장되는 값 (연결된 노드, 거리)
graph = [[] for _ in range(nodes+1)]

# graph에 노드간 연결, 거리 정보 저장
for _ in range(nodes-1):
    a, b, dist = map(int, input().split())
    graph[a].append((b, dist))
    graph[b].append((a, dist))

for _ in range(n):
    # visited로 거리 계산
    visited = [-1 for _ in range(nodes+1)]
    a, b = map(int, input().split())
    queue = deque()
    queue.append(a)
    visited[a] = 0
    while queue:
        now = queue.popleft()
        if now == b:
            print(visited[b])
            break

        for node, dist in graph[now]:
            if visited[node] == -1:
                # 거리 누적 (이전노드까지 걸린 거리 + 이전 노드에서 현재 노드까지 걸린 거리)
                visited[node] += (visited[now]+(dist+1))
                queue.append(node)











