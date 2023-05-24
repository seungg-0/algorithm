from collections import deque

def solution(places):
    answer = []
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    for place in places:
        tmp = []
        for item in place:
            tmp.append(list(item))
        place = tmp
        dist = [[-1]*5 for _ in range(5)]
        flag = False
        def bfs(x, y):
            nonlocal place, flag
            queue = deque()
            queue.append((x, y))
            while queue:
                x, y = queue.popleft()
                for i in range(4):
                    nx, ny = x+dx[i], y+dy[i]
                    if 0<= nx < 5 and 0<= ny < 5 and dist[nx][ny] == -1 and place[nx][ny] != 'X':
                        dist[nx][ny] = dist[x][y] + 1
                        if place[nx][ny] == 'P' and 0<= dist[nx][ny] <= 2:
                            flag = True
                            break
                        if place[nx][ny] == 'P':
                            dist[nx][ny] = 0
                            queue.append((nx, ny))
                        else:
                            queue.append((nx, ny))
                if flag:
                    break
        for i in range(5):
            if flag == True:
                break
            for j in range(5):
                if place[i][j] == 'P' and dist[i][j] == -1:
                    dist[i][j] = 0
                    bfs(i, j)

        if flag == False:
            answer.append(1)
        else:
            answer.append(0)
                        
    return answer




