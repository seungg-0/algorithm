'''
m행 n열 
접근가능 : 4면 중 적어도 1면이 창고 외부와 연결
A : 바깥면만 꺼낼 수 있음
AA : 안쪽도 꺼낼 수 있음 
남은 컨테이너 수 return

1. 찾자 마자 .으로 바로 바꾸면 안됨 (다 돌고 일괄로 바꿔줘야 함)
2. BFS를 써야 함. 외부와 연결된 .인지 확인하기 위해서

'''

from collections import deque

def solution(storage, requests):
    answer = 0
    
    original_m = len(storage)
    original_n = len(list(storage[0]))
    m = original_m+2
    n = original_n+2
    
    graph = [["."]*(n)]
    for s in storage:
        graph.append(["."]+list(s)+["."])
    graph.append(["."]*(n))
    
    dx = [-1, 1, 0 , 0]
    dy = [0, 0, -1, 1]
    
    for r in requests:
        # 크레인
        if(len(r)==2):
            for i in range(m):
                for j in range(n):
                    if(graph[i][j]==r[0]):
                        graph[i][j] = "."
        
        
        # 지게차
        if(len(r)==1): 
            changes = []
            visited = [[False]*(n) for _ in range(m)]
            visited[0][0] = True
            queue = deque([(0, 0)])
            while queue:
                x, y = queue.popleft()
                for i in range(4):
                    nx = x+dx[i]
                    ny = y+dy[i]
                    
                    if(0<=nx<m and 0<=ny<n):
                        if(graph[nx][ny]=="." and not visited[nx][ny]):
                            visited[nx][ny] = True
                            queue.append((nx, ny))
                        if(graph[nx][ny]==r and not visited[nx][ny]):
                            visited[nx][ny] = True
                            changes.append((nx, ny))
            
            for x, y in changes:
                graph[x][y] = "."
            

        
    for i in range(m):
        for j in range(n):
            if(graph[i][j]!="."):
                answer += 1
    
    
    return answer

