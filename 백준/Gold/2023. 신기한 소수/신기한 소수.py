# # 첫 번째 시도 - 시간초과 (백트래킹 생각하지 않고 로직 짬)
# import sys
# input = sys.stdin.readline
#
# n = int(input())
# answer = []
#
# def isPrime(num):
#     if num == 1:
#         return False
#     for i in range(2, num):
#         if num % i == 0: # 소수가 아니면
#             return False
#     return True
#
# if n == 1:
#     number = 2
# else:
#     num = '1'
#     for i in range(n-1):
#         num += '0'
#     number = int(num)
#
# while len(str(number)) == n:
#     if str(number)[0] in ('1', '4', '6', '8', '9'):
#         number = int(str(int(str(number)[0])+1) + str(number)[1:])
#     i = 1
#     number2 = number
#     while (isPrime(number2)):
#         if len(str(number2)[:n+1-i]) != 0:
#             number2 = int(str(number2)[:n + 1 - i])
#         else:
#             answer.append(number)
#             break
#         i += 1
#     number += 1
#
# for prime in answer:
#     print(prime)

# 정답 참고
# 1000부터 9999까지 하나씩 판별하려면 시간이 너무 오래 걸린다.
# 한자리 한자리 모두 소수여야 한다. -> 소수에 10을 곱하고 0부터 9까지 더해서 숫자들을 추려 주는 방식 사용
# 주어진 조건으로부터 로직을 유추해내는 연습 필요.
n = int(input())

# 소수 판별
def checkPrime(check_number):
    # 에라소스테네스의 체로 소수인지 확인
    for i in range(2, int(check_number**0.5)+1):
        if int(check_number) % i == 0:
            return False
    return True

def dfs(num):
    # 목표 깊이 도달 시 멈춘다.
    if len(str(num)) == n:
        print(num)
    else:
        for i in range(10): # 0부터 9까지 더해보기
            temp = num * 10 + i
            # 10을 곱하고 i를 더했을 때 소수인 경우만 dfs로 다음 자릿수 확인
            if checkPrime(temp):
                dfs(temp)

# 소수인 것으로 시작!
dfs(2)
dfs(3)
dfs(5)
dfs(7)