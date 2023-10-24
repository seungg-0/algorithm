from collections import deque

def solution(n, computers):
    answer = 0
    visited = [False]*len(computers)
    linked = [[] for _ in range(len(computers))]
    
    for i in range(len(computers)):
        for j in range(len(computers[0])):
            if computers[i][j] == 1:
                linked[i].append(j)
                linked[j].append(i)
    
    queue = deque()
    def bfs():
        while queue:
            node = queue.popleft()
            for n in linked[node]:
                if not visited[n]:
                    visited[n] = True
                    queue.append(n) 
        return True
    
    for i in range(len(computers)):
        if not visited[i]:
            visited[i] = True
            queue.append(i)
            if bfs(): # 하나의 노트 묶음 탐색
                answer += 1
    
    
    return answer