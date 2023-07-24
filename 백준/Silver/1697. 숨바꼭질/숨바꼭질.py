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
        for new_loc in (loc-1, loc+1, 2*loc):
            if 0 <= new_loc < MAX and times[new_loc] == 0:
                times[new_loc] = times[loc] + 1
                queue.append(new_loc)

dfs(subin)

