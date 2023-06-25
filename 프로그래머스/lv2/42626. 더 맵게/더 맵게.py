from heapq import heappush, heappop, heapify

def solution(scoville, K):
    answer = 0
    heapify(scoville)

    while scoville[0] < K: # 가장 작은 값이 K보다 커지기 전까지 반복
        heappush(scoville, heappop(scoville) + heappop(scoville)*2) # 섞기
        answer += 1
        if len(scoville) == 1 and scoville[0] < K: # 계속 섞으면 마지막은 1, 마지막이 K보다 작으면 -1
            return -1
        
    return answer