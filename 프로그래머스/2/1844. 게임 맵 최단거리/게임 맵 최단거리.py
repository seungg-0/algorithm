from collections import deque

def solution(maps):
    answer = 0
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == 1:
                maps[i][j] = 0
            elif maps[i][j] == 0:
                maps[i][j] = -1
    
    maps[0][0] = 1
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    queue = deque()
    queue.append([0, 0])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and maps[nx][ny] == 0:
                maps[nx][ny] = maps[x][y] + 1
                queue.append([nx, ny])
        
    if maps[len(maps)-1][len(maps[0])-1] == 0:
        return -1
    else:
        return maps[len(maps)-1][len(maps[0])-1]
    return answer