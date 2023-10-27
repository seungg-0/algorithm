from collections import deque

def solution(n, computers):
    answer = 0
    row, col = len(computers), len(computers[0])
    connected = [[] for _ in range(row)]
    visited = [False]*n
    
    for i in range(row):
        for j in range(col):
            if computers[i][j] == 1:
                connected[i].append(j)
                connected[j].append(i)
    
    def bfs():
        while queue:
            node = queue.popleft()
            for n in connected[node]:
                if node != n and not visited[n]:
                    visited[n] = True
                    queue.append(n)
        return True
      
    
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            queue = deque()
            queue.append(i)
            bfs()
            answer += 1
    
    return answer