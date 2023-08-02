# 소수 : 1과 자기자신만으로 나누어떨어지는 1이 아닌 양의 정수
# 소수인지 판단 ?

from itertools import permutations

def solution(numbers):
    answer = 0
    # 소수인지 판단하는 함수
    def isdecimal(num):
        if num <= 1:
            return False
        if num == 2:
            return True
        for i in range(2, num):
            if num % i == 0:
                return False
        return True
    
    permu_list = []
    for i in range(len(numbers)):
        if i == 0:
            for num in numbers:
                permu_list.append(int(num))
        if i > 0:
            for permu in permutations(numbers, i + 1):
                permu = list(permu)
                permu = ''.join(permu)
                permu_list.append(int(permu))
    
    tmp = set(permu_list)
    permu_list = list(tmp)
    for num in permu_list:
        if isdecimal(num) == True:
            answer += 1

    return answer