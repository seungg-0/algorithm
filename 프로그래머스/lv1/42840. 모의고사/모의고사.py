def solution(answers):
    answer = [0, 0, 0]
    first = [1, 2, 3, 4, 5] # 5
    second = [2, 1, 2, 3, 2, 4, 2, 5] # 8
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] # 10
    
    for i in range(len(answers)):
        answer[0] += first[i%5]==answers[i]
        answer[1] += second[i%8]==answers[i]
        answer[2] += third[i%10]==answers[i]
    
    result = []
    maximum = max(answer)
    
    for idx, v in enumerate(answer):
        if v == maximum:
            result.append(idx+1)
    
    return result