# 건너건너 연결돼있어도 같은 네트워크상에 존재
# 네트워크의 갯수 반환
from collections import deque

def solution(n, computers):
    connected_info = [[] for _ in range(n+1)]
    visited = [False]*(n+1)
    
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if computers[i][j] == 1:
                # i에 j가 연결되어 있다
                connected_info[i].append(j)
                connected_info[j].append(i)

    queue = deque()
    count = 0
    def bfs(start, visited):
        queue.append(start)
        while queue:
            now = queue.popleft()
            for i in connected_info[now]:
                if not visited[i]:
                    visited[i] = True
                    queue.append(i)
        return True
    
    for i in range(n):
        if not visited[i]:
            if bfs(i, visited):
                count += 1
    answer = count
    
    return answer