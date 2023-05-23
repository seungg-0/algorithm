def solution(lottos, win_nums):
    answer = []
    result = {6: 1, 5: 2, 4: 3, 3: 4, 2: 5, 1:6, 0:6}
    lottos.sort()
    win_nums.sort()
    cnt = 0
    num_zero = lottos.count(0)
    for i in lottos:
        for j in win_nums:
            if i == j:
                cnt += 1

    answer.append(result[cnt + num_zero])
    answer.append(result[cnt])

    
    return answer