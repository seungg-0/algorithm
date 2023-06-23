# 힙 함수 활용하기
# heapq.heappush(heap, item) : item을 heap에 추가
# heapq.heappush(heap, 50)
# heapq.heappop(heap) : heap에서 가장 작은 원소를 pop & 리턴. 비어 있는 경우 IndexError가 호출됨. 
# result = heapq.heappop(heap)
# heapq.heapify(x) : 리스트 x를 즉각적으로 heap으로 변환함 (in linear time, O(N) )
import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)

    while scoville[0] < K: # 가장 작은 값이 K보다 작으면
        heapq.heappush(scoville, heapq.heappop(scoville) + heapq.heappop(scoville)*2) # 섞기
        answer += 1
        if len(scoville) == 1 and scoville[0] < K: # 계속 섞으면 마지막은 1, 마지막이 K보다 작으면
            return -1

    return answer