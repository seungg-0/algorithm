# i번째 집 물류창고에서 거리 i만큼 떨어져 있음
# i번째 집은 j번째 집과 거리 j-i
# 트럭에 재활용 택배 상자 최대 cap개 실을 수 있음
# 배달하면서, 빈재활용 택배 상자 수거
# 트럭 하나로 모두 배달과 수거를 마치고 돌아오는 최소 이동 거리
# BFS?

# 뒤부터 탐색하면서 "배송할 택배 or 수거할 상자" 있으면 처리, 거리 +
# -> 수거나 배달 하는경우만 거리 더해주면 됨.

# -> 실패, 정답 참고 : "그리디"

def solution(cap, n, deliveries, pickups):
    deliveries = deliveries[::-1]
    pickups = pickups[::-1]
    answer = 0

    have_to_deli = 0
    have_to_pick = 0

    for i in range(n):
        # 생각 못한 부분 
        have_to_deli += deliveries[i] # 이렇게 해주면 남는 공간 다른 집 배달 자동 처리 가능
        have_to_pick += pickups[i]

        while have_to_deli > 0 or have_to_pick > 0:
            have_to_deli -= cap
            have_to_pick -= cap
            answer += (n - i) * 2

    return answer

# 보통 조건에 값의 범위가 커서 시간초과가 걱정될 경우엔 for문 안에서 배열을 조작하거나 함수를 쓰기보단
# have_to_deli, have_to_pick 이런식으로 변수를 만들어서 활용해야 한다.