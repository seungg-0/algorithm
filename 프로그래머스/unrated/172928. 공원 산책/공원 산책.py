from collections import deque

# E(0, 1), W(0, -1), S(1, 0), N(-1, 0)
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
def solution(park, routes):
    answer = []
    graph = []
    routes_dq = deque(routes)
    for p in park:
        graph.append(list(p))
        
    flag = False
    for i in range(len(graph)):
        for j in range(len(graph[0])):
            if graph[i][j] == 'S':
                flag = True
                x, y = i, j # 시작지점 저장
                xs, ys = x, y
                break
        if flag:
            break

    while routes_dq:
        available = True
        direction, n = routes_dq.popleft().split(" ")
        n = int(n)
        if direction == 'E':
            for i in range(n):
                nx, ny = x+dx[0], y+dy[0]
                if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] != 'X': # 이동 할 수 있는지 확인
                    x, y = nx, ny
                else: # 이동 불가능할 경우 다음 명령으로
                    available = False
                    x, y = xs, ys
                    break
            if available: # 이동 가능하다면 위치 바꿔주기
                graph[xs][ys] = 'O'
                graph[x][y] = 'S'
                xs, ys = x, y
        elif direction == 'W':
            for i in range(n):
                nx, ny = x+dx[1], y+dy[1]
                if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] != 'X': # 이동 할 수 있는지 확인
                    x, y = nx, ny
                else: # 이동 불가능할 경우 다음 명령으로
                    available = False
                    x, y = xs, ys
                    break
            if available: # 이동 가능하다면 위치 바꿔주기
                graph[xs][ys] = 'O'
                graph[x][y] = 'S'
                xs, ys = x, y
        elif direction == 'S':
            for i in range(n):
                nx, ny = x+dx[2], y+dy[2]
                if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] != 'X': # 이동 할 수 있는지 확인
                    x, y = nx, ny
                else: # 이동 불가능할 경우 다음 명령으로
                    x, y = xs, ys
                    available = False
                    break
            if available: # 이동 가능하다면 위치 바꿔주기
                graph[xs][ys] = 'O'
                graph[x][y] = 'S'
                xs, ys = x, y
        elif direction == 'N':
            for i in range(n):
                nx, ny = x+dx[3], y+dy[3]
                if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] != 'X': # 이동 할 수 있는지 확인
                    x, y = nx, ny
                else: # 이동 불가능할 경우 다음 명령으로
                    available = False
                    x, y = xs, ys
                    break
            if available: # 이동 가능하다면 위치 바꿔주기
                graph[xs][ys] = 'O'
                graph[x][y] = 'S'
                xs, ys = x, y
                   
    flag = False
    for i in range(len(graph)):
        for j in range(len(graph[0])):
            if graph[i][j] == 'S':
                answer.append(i)
                answer.append(j)
                flag = True
                break
        if flag:
            break
    return answer



