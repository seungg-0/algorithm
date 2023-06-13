# numbers 앞에서부터 하나씩 새로운 리스트에 담는다
# 새로운 리스트에 들어있는 숫자들보다 큰 수가 들어오면 새로운 리스트의 값 삭제 (K값 비교)

def solution(number, k):
    answer = ''
    answer_list = []
    for num in number:
        if k > 0:
            if len(answer_list) == 0:
                answer_list.append(num)
            else:
                while True:
                    if len(answer_list) > 0 and answer_list[-1] < num and k>0:
                        k -= 1
                        answer_list.pop()
                    else:
                        break
                answer_list.append(num)
        else:
            answer_list.append(num)
    
    answer = ''.join(answer_list)
    if k > 0:
        answer = answer[:-k]
    return answer