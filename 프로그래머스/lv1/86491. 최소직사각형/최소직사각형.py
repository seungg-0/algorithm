# 아이디어
# step 1. 가로, 세로 각각의 최댓값 구하기
# step 2. 가로, 세로 최댓값 중 작은 부분은 가로, 세로 길이 중 더 짧은 값으로 바꾸기

def solution(sizes):
    answer = 0
    max_left, max_right = -1e9, -1e9
    maximum2 = -1e9
    
    # 가로, 세로 각각 최댓값 구하기
    for i in range(len(sizes)):
        max_left = max(max_left, sizes[i][0])
        max_right = max(max_right, sizes[i][1])
    
    if max_left > max_right:
        maximum = max_left
    else:
        maximum = max_right
    
    # 가로, 세로 최댓값 구했을 때 작은 부분은 각 명함의 가로, 세로를 바꿨을 때 작은 값으로 두고 그렇게 바꿨을 때의 최댓값 구하기
    for i in range(len(sizes)):
        maximum2 = max(maximum2, min(sizes[i]))
            
    answer = maximum*maximum2
    
    return answer