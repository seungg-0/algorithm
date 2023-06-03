from collections import deque

# out_queue에 값이 있을 때 tmp가 '(' 이면 append, ')'이면 pop
# out_queue에 값이 없을 때 tmp가 '(' 이면 append, ')'이면 false
def solution(s):
    answer = True
    queue = deque()
    for i in s:
        queue.append(i)

    out_queue = deque()
    while queue:
        tmp = queue.popleft()
        if len(out_queue) == 0 and tmp == ')':
            answer = False
            break
        elif len(out_queue) == 0:
            out_queue.append(tmp)
        elif tmp == '(':
            out_queue.append(tmp)
        else:
            out_queue.pop()
    if len(out_queue) > 0:
        answer = False
    
    return answer