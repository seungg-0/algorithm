def solution(n, works):
    answer = 0
    # key : 업무량, value : 해당 업무량을 가진 일의 갯수
    work_dict = {}
    for work in works:
        # key값이 이미 있으면
        if work_dict.get(work):
            work_dict[work] = work_dict[work] + 1
        # key값이 없으면
        else:
            work_dict[work] = 1

    # keys : 업무별 일해야 하는 시간에서 중복 제거한 값들
    keys = list(work_dict.keys())
    keys.sort()
    while n > 0:
        max_key = keys[-1]
        # 가장 큰 업무 1시간 처리
        work_dict[max_key] -= 1
        # 가장 큰 업무가 유일한 가장 큰 업무였다면 keys에서 제거
        if work_dict[max_key] == 0:
            keys.pop()
        # 1시간 업무 처리 후 해당 업무량을 가진 업무가 또 있다면 해당 업무량의 일의 갯수 + 1
        if work_dict.get(max_key-1):
            work_dict[max_key-1] += 1
        # 1시간 업무 처리 후 해당 업무량을 가진 업무가 또 있다면 새로 넣어주기
        elif max_key > 1:
            keys.append(max_key-1)
            keys.sort()
            work_dict[max_key-1] = 1
        # 업무를 다끝냈다면 종료
        if len(keys) == 0:
            break
        n -= 1

    for key in keys:
        # work_dict[key] : 업무 갯수
        answer += key * key * work_dict[key]
    return answer