'''
문자열에서 같은 값이 연속해서 나타나는 것을 
그 문자의 개수와 반복되는 값으로 표현

1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이 리턴

'문자열 비교'를 하면 됨
반복은 전체길이//2 까지만 (왜냐 ? 절반 자른게 최대로 자른거라)
자르기 전 값이랑 같은지 비교
'''

'''
def solution(s):
    answer = 1e9 # 암기

    for length in range(1, len(s)//2+1):
        prev = ""
        count = 1
        idx = 0
        tmp_answer = 0
        while(idx<len(s)):
            current = s[idx:idx+length]
            if(prev==current): # 같을 때
                count += 1
                idx += length
            else: # 다를 때
                if(count>1):
                    tmp_answer += len(str(count))
                tmp_answer += len(prev)
                idx += length
                prev = current # prev 업데이트
                count = 1
                  
                    
        # 마지막 문자열 처리
        if count > 1:
            tmp_answer += len(str(count))

        tmp_answer += len(prev)

        answer = min(answer, tmp_answer)
        

    return answer
 '''

def solution(s):
    answer = len(s)

    for length in range(1, len(s)//2+1):
        prev = ""
        count = 1
        idx = 0
        tmp_answer = 0

        while idx < len(s):
            current = s[idx:idx+length]

            if prev == current:
                count += 1

            else:
                if count > 1:
                    tmp_answer += len(str(count))

                tmp_answer += len(prev)

                prev = current
                count = 1

            idx += length

        # 마지막 문자열 처리
        if count > 1:
            tmp_answer += len(str(count))

        tmp_answer += len(prev)

        answer = min(answer, tmp_answer)

    return answer
    