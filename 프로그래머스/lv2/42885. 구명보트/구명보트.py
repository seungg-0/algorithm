# 오름차순 정렬
# (가장 가벼운 사람 + 가장 무거운 사람) <= limit : 한 번에 두명 구출 가능
# 아니면 한 번에 한명 구출 가능

from collections import deque
def solution(people, limit):
    answer = 0
    people.sort()
    people_dq = deque(people)
    print(people_dq)
    while people_dq:
        if len(people_dq) == 1:
            answer += 1
            break
        front = people_dq.popleft()
        back = people_dq.pop()
        if front + back <= limit: # 두명 구출
            answer += 1
        else:  # 한명 구출 (무거운 사람 (back))
            people_dq.appendleft(front)
            answer += 1
    return answer