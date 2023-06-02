from collections import deque
# 숫자 클수록 우선순위 높음

# 큐에서 하나 꺼내기 popleft
# 큐에 남은 값들과 비교 - 우선순위 높은거 있다면 append / 아니라면 
def solution(priorities, location):
    answer = 0
    # 중요도, 위치
    # dict로 우선순위 비교
    priorities_dict = {} # key : 인덱스 value : 우선순위
    process = deque()
    for idx, val in enumerate(priorities):
        priorities_dict[idx] = val
        process.append(idx)
    print(process)
    while True:
        flag = False
        tmp = process.popleft()
        for i in process:
            if priorities_dict[tmp] < priorities_dict[i]:
                flag = True
        if flag:
            process.append(tmp)
        else:
            print(tmp, location, process, answer)
            answer += 1
            if tmp == location:
                break

    return answer