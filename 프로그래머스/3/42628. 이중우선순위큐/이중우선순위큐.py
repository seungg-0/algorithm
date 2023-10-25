from heapq import heapify, heappop, heappush

def solution(operations):
    answer = []
    queue = []
    heapify(queue)
    for operation in operations:
        left, right = operation.split(" ")
        if left == 'I': # 큐에 주어진 숫자 삽입
            heappush(queue, int(right))
        elif right == '1': # 큐에서 최댓값을 삭제
            if len(queue) == 0:
                continue
            if len(queue) == 1:
                heappop(queue)
            else:
                # 최대 힙 만들어주기
                reverse_sign = lambda x:x*(-1)
                max_heap = list(map(reverse_sign, queue))
                heapify(max_heap)
                max_heap = list(map(reverse_sign, max_heap))
                max_heap.pop(0) # 최댓값 삭제
                heapify(max_heap)
                queue = max_heap
        else: # 큐에서 최솟값을 삭제
            if len(queue) >= 1: # 최솟값 삭제
                heappop(queue)
    
    if len(queue) == 0:
        answer = [0, 0]
    else:
        answer.append(max(queue))
        answer.append(queue[0])
    return answer