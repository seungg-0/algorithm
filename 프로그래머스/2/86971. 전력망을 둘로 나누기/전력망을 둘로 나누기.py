from collections import deque

def bfs(start, visited, connected):
    queue = deque()
    queue.append(start)
    visited[0] = True
    cnt = 1
    while queue:
        node = queue.popleft()
        for w in connected[node]:
            if not visited[w]:
                visited[w] = True
                queue.append(w)
                cnt += 1
    return cnt

def solution(n, wires):
    answer = 1e9        
    for i in range(n-1):
        visited = [False]*n
        connected = [[] for _ in range(n)]
        for idx, wire in enumerate(wires):
            if idx == i:
                continue
            else: # 연결 정보 저장
                connected[wire[0]-1].append(wire[1]-1)
                connected[wire[1]-1].append(wire[0]-1)
        
        cnt = bfs(0, visited, connected)
        answer = min(answer, abs((n-cnt)-cnt))
                       
    return answer