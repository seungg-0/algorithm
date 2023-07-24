# +1, -1, *2 세개의 노드
# 걸리는 최소 시간 (최소 깊이)를 구하는 것이기 때문에 bfs
# dfs로 깊이 하나씩 구하면 너무 오래 걸림

import sys
input = sys.stdin.readline
from collections import deque

subin, sis = map(int, input().split())
MAX = 100001
times = [0] * MAX

def dfs(v):
    queue = deque([v])
    while queue:
        loc = queue.popleft()
        if loc == sis:
            return print(times[loc])
        # 트리의 깊이 1만큼씩 탐색
        for new_loc in (loc+1, loc-1, 2*loc):
            if 0 <= new_loc < MAX and times[new_loc] == 0:
                times[new_loc] = times[loc] + 1
                queue.append(new_loc)

dfs(subin)

