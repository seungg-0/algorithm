
# 시도1 -> 실패 (bfs탐색으로 하면 방향을 틀 때 계속 누적값이 계산된다)
# 검 : 1 / 흰 : 2
# 검정이 이기면 1, 흰색이 이기면 2, 승부결정 안났음 0 / 가장 왼 혹은 위쪽 행, 열 번호 출력

# import sys
# input = sys.stdin.readline
# from collections import deque

# graph = []
# tmp = list(map(int, list(input().split())))
# graph.append(tmp)
# for _ in range(len(tmp)-1):
#     graph.append(list(map(int, list(input().split()))))
#
# counting = [[0]*len(graph[0]) for _ in range(len(graph))]
#
# dx = [0, 1, 1, 1]
# dy = [1, 0, 1, -1]
#
# def bfs():
#     x, y = queue.popleft()
#     for i in range(4):
#          nx, ny = x+dx[i], y+dy[i]
#          if 0<= nx < len(graph) and 0<= ny < len(graph[0]):
#              if (graph[x][y] == graph[nx][ny]) and (counting[nx][ny] == 0):
#                 counting[nx][ny] = counting[x][y]+1
#                 queue.append([nx, ny])
#
# def findFive():
#     for i in range(len(counting)):
#         for j in range(len(counting[0])):
#             if counting[i][j] == 5:
#                 return True
#
# queue = deque()
# for i in range(len(graph)):
#     for j in range(len(graph[0])):
#         if (graph[i][j] == 1) or (graph[i][j] == 2) and (counting[i][j] == 0):
#             counting[i][j] = 1
#             queue.append([i, j])
#             bfs()
#             if findFive():
#                 print(graph[i][j])
#                 print(counting)
#                 print(i+1, j+1)


# Brute Force로 풀어야 했던 것..

import sys
input = sys.stdin.readline

graph = []
dx = [1, 0, -1, 1] # 양쪽방향 중 각 한 방향씩으로만
dy = [0, 1, 1, 1]

for _ in range(19):
    graph.append(list(map(int, input().split())))

for x in range(19):
    for y in range(19):
        if graph[x][y] != 0:
            for i in range(4):
                cnt = 1
                nx, ny = x+dx[i], y+dy[i]
                while 0 <= nx < 19 and 0 <= ny < 19 and graph[nx][ny] == graph[x][y]:
                    cnt += 1
                    if cnt == 5:
                        # 육목인지 체크해야 함 (첫 째 바둘돌보다 한칸 이전, 마지막 바둑돌보다 한 칸 이후
                        if 0 <= x - dx[i] < 19 and 0 <= y - dy[i] < 19 and graph[nx][ny] == graph[x-dx[i]][y-dy[i]]:
                            break
                        if 0 <= nx+dx[i] < 19 and 0 <= ny+dy[i] < 19 and graph[nx][ny] == graph[nx+dx[i]][ny+dy[i]]:
                            break
                        else:
                            print(graph[nx][ny])
                            print(x+1, y+1)
                            exit(0)
                    if cnt > 5:
                        break
                    nx, ny = nx + dx[i], ny + dy[i]  # 같은 방향으로 계속 탐색해야 함.

print(0)