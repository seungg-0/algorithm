from collections import deque
def solution(n, wires):
    answer = []
    
    def bfs(queue, visited):
        cnt = 1
        while queue:
            n = queue.popleft()
            for i in connected[n]:
                if not visited[i]:
                    visited[i] = True
                    queue.append(i)
                    cnt += 1
        return cnt
    
    for i in range(n-1):
        connected = [[] for _ in range(n+1)]
        visited = [False]*(n+1)
        # 연결 정보 저장
        for idx, val in enumerate(wires):
            if idx == i:
                continue
            else:
                connected[val[0]].append(val[1])
                connected[val[1]].append(val[0])
        # 연결 갯수 세기
        queue = deque()
        queue.append(1)
        visited[1] = True
        cnt = bfs(queue, visited)
        answer.append(abs((n-cnt)-cnt))
            
    return min(answer)