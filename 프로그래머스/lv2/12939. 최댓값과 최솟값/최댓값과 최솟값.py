def solution(s):
    answer = ''
    answer_list = list(map(int, s.split()))
    minimum = 1e9
    maximum = -1e9
    
    for num in answer_list:
        minimum = min(minimum, num)
        maximum = max(maximum, num)
    
    answer = str(minimum) + " " + str(maximum)
    
    return answer