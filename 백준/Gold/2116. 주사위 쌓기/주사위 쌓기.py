import sys
input = sys.stdin.readline

# 정답 참고 (첫 번째 주사위(6가지)가 결정되면 나머지 모두 결정.) -> 주사위 아무리 많아도 모든 경우의 수 따져볼 수 있음.
# 1. 주사위 아랫면에 따라 윗면이 어떻게 결정되는지 로테이션을 dictionary에 저장
# 2. 첫 번째 주사위를 기준으로, 아랫면을 두는 모든 경우의 수 (1~6) 확인
# 3. 모든 경우의 수를 순회하며 각각의 경우의 최대값과 이전의 최대값을 비교
# 4. 최종적인 최대값을 출력

N = int(input())
dice = []
for _ in range(N):
    dice.append(list(map(int, input().split())))
rotate = {0 : 5, 1 : 3, 2 : 4, 3 : 1, 4 : 2, 5 : 0}

maxnum = 0 # 최대값을 저장해둘 상수 선언
for i in range(6): # 첫 번째 주사위 기준 1~6까지 모두 순회
    result = [] # 각 주사위마다 옆면의 최대값 1개를 저장해둘 리스트 선언
    temp = [1, 2, 3, 4, 5, 6] # 주사위 각 면에 써져있는 1~6
    temp.remove(dice[0][i]) # 주사위 아랫면 숫자 제거
    next = dice[0][rotate[i]] # 첫 번째 주사위의 윗면 값 계산
    temp.remove(next) # 첫 번째 주사위의 윗면 값 삭제
    result.append(max(temp)) # 첫 번째 주사위의 옆면들 중 가장 큰 값 삽입
    for j in range(1, N): # 두 번쨰 주사위부터 마지막 주사위까지 반복
        temp = [1, 2, 3, 4, 5, 6]
        temp.remove(next) # 현재 주사위의 아랫면 숫자 제거
        next = dice[j][rotate[dice[j].index(next)]] # 현재 주사위의 윗면 계산
        temp.remove(next) # 현재 주사위의 윗면 삭제
        result.append(max(temp)) # 현재 주사위의 옆면 중 가장 큰 값 삽입
    result = sum(result) # 각 주사위마다의 최대값 모두 더하기
    maxnum = max(maxnum, result)

print(maxnum)




