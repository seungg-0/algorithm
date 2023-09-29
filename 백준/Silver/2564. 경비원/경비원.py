# 시도 1 - 3%에서 틀렸습니다. (반례를 찾지 못했다.)
# import sys
# input = sys.stdin.readline
#
# # 1,2 : 위, 아래 / 3, 4 : 왼, 오
# # 거리 구하는 공식 세 가지 케이스 : 위-아래 / 위-위 / 왼-아래
#
# w, h = map(int, input().split())
# n = int(input())
# dongGeun = []
#
# # 상점 위치 저장
# graph = []
# for i in range(n+1):
#     dir, dist = map(int, input().split())
#     if dir == 1: # 북쪽 위치
#         graph.append([0, dist])
#     elif dir == 2: # 남쪽 위치
#         graph.append([h, dist])
#     elif dir == 3: # 서쪽 위치
#         graph.append([dist, 0])
#     else: # 동쪽 위치
#         graph.append([dist, w])
#
# dongGeun = graph.pop()
# total_dist = 0
#
# # 상점과 동근이 위치 계산
# for x, y in graph:
#     if x == dongGeun[0] or y == dongGeun[1]: # 같은 라인에 있는 경우
#         total_dist += (abs(x-dongGeun[0])+abs(y-dongGeun[1]))
#     elif (x in (0, h) and dongGeun[1] in (0, w)) or (y in (0, w) and dongGeun[0] in (0, h)): # 다른 라인 (ex. 동, 남)에 있는 경우
#         total_dist += (abs(x-dongGeun[0])+abs(y-dongGeun[1]))
#     else: # 다른 라인 (ex. 북 남)에 있는 경우
#         if x in (0, h): # 북-남
#             total_dist += (h+min(y+dongGeun[1], (w-y)+(w-dongGeun[1])))
#         else: # 동-서
#             total_dist += (w+min(x+dongGeun[0], (h-x)+(h-dongGeun[0])))
#
# print(total_dist)

# 정답 참고
# 상점과 동근이의 상대 거리가 아닌 절대 거리를 이용해서 풀이
# 상점(1), 동근이(2) 모두 (0, 0)으로부터 떨어진 거리를 계산하고(절대거리) min(abs((1)-(2)), 둘레의 길이-abs((1)-(2)))
import sys
input = sys.stdin.readline

w, h = map(int, input().split())
n = int(input())
stores = []

def calcDist(dir, dist):
    if dir == 1:
        return dist
    elif dir == 2:
        return w+h+(w-dist)
    elif dir == 3:
        return w+h+w+(h-dist)
    else:
        return w+dist

for i in range(n+1):
    if i == n:
        dir_dong, dist_dong = map(int, input().split())
    else:
        stores.append(list(map(int, input().split())))

total = 0
dist_dongGeun = calcDist(dir_dong, dist_dong) # (0, 0)으로부터 동근이 거리
for i in range(n):
    dist_store = calcDist(stores[i][0], stores[i][1]) # (0, 0)으료부터 상점의 거리
    path1 = abs(dist_dongGeun-dist_store)
    path2 = 2*w + 2*h - path1
    total += min(path1, path2)

print(total)


