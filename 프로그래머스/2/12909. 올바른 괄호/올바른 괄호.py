# 괄호 바르게 짝지어졌다 : ( 로 시작, ) 로 끝
# queue 자료형 ? pop() / ( 이면 쌓다가 ) 이 들어오면 하나씩 pop 맨 마지막에 비어있으면 true 아니면 false / 빈 상태에서 )가 들어와도 false

from collections import deque

def solution(s):
    answer = True
    s_list = list(s)
    s_queue = deque()

    for s in s_list:
        if s == ')' and len(s_queue) == 0:
            return False
        if s == '(':
            s_queue.append(s)
        if s == ')' and len(s_queue) > 0:
            s_queue.popleft()
    if len(s_queue) > 0:
        return False
    else:
        return True