# numbers의 원소 중 가장 큰 수 1,000 (네자릿수)
# 34, 3 비교시 3434 3333 형태로 만들어서 비교하기
# 시간복잡도 "N(logN)" sort 함수

# 예외 : 모두 0인 경우

def solution(numbers):
    answer = ''
    numbers = list(map(str, numbers))
    numbers.sort(key = lambda x : (x*4)[:4], reverse=True)
    if numbers[0] == '0':
        answer = "0"
    else:
        answer = ''.join(numbers)
    
    return answer