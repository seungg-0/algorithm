# 소수 숫자의 (2, 3, 5, ~~)
# (1)양쪽에 0이 있는 경우, (2)오른쪽에만 0 왼쪽엔 아무것도 없는 경우, (3)그 반대, (4)양쪽에 아무것도 없는 경우
# 1만 따로 처리 해주고, 2, 3은 양쪽끝, 4는 길이가 1일때
# 1은 flag로? 0 있었으면 True, True인 상태에서 또 0 만나면 소수 판별
import math
def solution(n, k):
    answer = 0
    
    # 에라토스테네스의 체 소수 판별법
    def is_primenum(x): # x가 소수인지 확인하는 알고리즘
        if x < 2:
            return False
        for i in range(2, int(math.sqrt(x) + 1)):
            if x % i == 0:
                return False
        return True
    
    # n 숫자를 k진수로 바꾸기
    lis = []
    left = n
    while left >= k:
        lis.append(str(left%k))
        left //= k
    lis.append(str(left))
    lis = lis[::-1]

    number = ''.join(lis)
    
    
    # number = str(number)
    print(number)
    
    # 4번 케이스
    if len(number) == 1:
        if is_primenum(number):
            return 1

    # 1번 케이스
    flag = False
    tmp = ''
    for i in range(len(number)):
        if i == 0 and number[i] != '0':
            flag = True
            tmp += number[i]
            continue
        if number[i] == '0':
            if flag:
                if len(tmp) != 0 and is_primenum(int(tmp)):
                    answer += 1
                tmp = ''
            else:
                flag = True
                tmp += number[i]
        elif i == len(number)-1:
            if flag and number[i] == '0':
                if len(tmp) != 0 and is_primenum(int(tmp)):
                    answer += 1
            elif flag and number[i] != '0':
                tmp += number[i]
                if len(tmp) != 0 and is_primenum(int(tmp)):
                    answer += 1
        else:
            tmp += number[i]
        
    return answer



# 에라토스테네스의 체 소수 판별법
# def is_primenum(x):
#     for i in range (2, int(math.sqrt(x) + 1):
#     	if x % i == 0:
#         	return False
#     return True