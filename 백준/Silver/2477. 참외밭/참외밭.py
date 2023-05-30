import sys
input = sys.stdin.readline

# 동 서 남 북 1 2 3 4 (가로 : 동 서 1 2 세로 : 남 북 3 4)

melon = int(input())

arr = []
for i in range(6):
    arr.append(list(map(int, input().split())))

max_width = [0, 0]
max_height = [0, 0]
for i in range(6):
    if (arr[i][0] == 1 or arr[i][0] == 2) and (arr[i][1] > max_width[1]):
        max_width = [i, arr[i][1]]
    elif (arr[i][0] == 3 or arr[i][0] == 4) and (arr[i][1] > max_height[1]):
        max_height = [i, arr[i][1]]

min_width = abs(arr[(max_height[0]+1)%6][1]-arr[(max_height[0]-1)%6][1])
min_height = abs(arr[(max_width[0]-1)%6][1]-arr[(max_width[0]+1)%6][1])

print(melon*(max_width[1]*max_height[1]-min_width*min_height))

