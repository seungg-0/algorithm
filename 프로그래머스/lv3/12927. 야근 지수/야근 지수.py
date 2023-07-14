# (전체 일을 마치는데 걸리는 시간) - n : 총 야근 시간
# 최대한 많이 쪼갤수록 제곱했을 때 작은 값이 나옴
# 총 야근 시간 / 일의 갯수 -> 나누어 떨어지지 않는 경우는 나머지 버리고 몫만 구한 값을 분자에서 빼주고 분모 -1

def solution(n, works):
    answer = 0
    work_dict = {}
    for work in works:
        if work_dict.get(work):
            work_dict[work] = work_dict[work] + 1
        else:
            work_dict[work] = 1
    keys = list(work_dict.keys())
    keys.sort()
    while n > 0:
        max_key = keys[-1]
        work_dict[max_key] = work_dict[max_key] - 1
        if work_dict[max_key] == 0:
            keys.pop()
        if work_dict.get(max_key-1):
            work_dict[max_key-1] = work_dict[max_key-1] + 1
        elif max_key > 1:
            keys.append(max_key-1)
            keys.sort()
            work_dict[max_key-1] = 1
        if len(keys) == 0:
            break
        n = n - 1
    for key in keys:
        answer += key * key * work_dict[key]
    return answer