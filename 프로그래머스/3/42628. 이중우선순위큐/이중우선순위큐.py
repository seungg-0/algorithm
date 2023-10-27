# I 숫자	큐에 주어진 숫자를 삽입합니다.
# D 1	큐에서 최댓값을 삭제합니다.
# D -1	큐에서 최솟값을 삭제합니다.

from heapq import heapify, nlargest, heappop, heappush
def solution(operations):
    answer = []
    queue = []
    heapify(queue)
    # heappush(queue, 1)
    # print(heappop(queue))

    for operation in operations:
        typ, num = operation.split(" ")
        if typ == 'I': # 큐에 주어진 숫자를 삽입합니다.
            heappush(queue, int(num))
        elif num == '1':
            queue = nlargest(len(queue), queue)[1:]
            heapify(queue)
        else:
            if len(queue) >= 1:
                heappop(queue)
    
    if len(queue) == 0:
        return [0, 0]
    answer.append(max(queue))
    answer.append(heappop(queue))

    return answer