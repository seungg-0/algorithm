from collections import deque

def solution(queue1, queue2):
    answer = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    length = len(queue1)
    sum1 = sum(queue1)
    sum2 = sum(queue2)

    for _ in range(length*3):
        if sum1 == sum2:
            return answer
        if sum1 > sum2:
            sum1 -= queue1[0]
            sum2 += queue1[0]
            queue2.append(queue1.popleft())
            answer += 1
        else:
            sum1 += queue2[0]
            sum2 -= queue2[0]
            queue1.append(queue2.popleft())
            answer += 1
    
    return -1
