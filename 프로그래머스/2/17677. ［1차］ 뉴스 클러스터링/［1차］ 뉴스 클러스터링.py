'''
자카드 유사도 : 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의
집합 A, B가 공집합일 경우 자카드 유사도 1 
교집합 : min(A일부, B일부)
합집합 : max(A일부, B일부)

- 두글자씩 끊어서 다중집합의 원소 만듬
- 영문자로 된 글자 쌍만 유효, 공백이나 숫자, 특수 문자 들어있으면 제외
- 대소문자 동일하게 취급
- 결과는 65536을 곱한 후 소수점 아래를 버리고 정수만 출력 
! 두 집합이 모두 공집합이면 자카드 유사도 1

step1 len(str1)-1 까지 탐색하며 두개씩 자름, 영문자로 구성됐는지 판단 (tmp.isalpha() and tmp.isascii() 사용)
step2 집합 두개 완성하면, 딕셔너리로 각각 문자-갯수 자료형 만들고, key 탐색하며 교집합, 합집합 구함

* tmp.isalpha() and tmp.isascii() # tmp.isalpha() and tmp.isascii() 두 조건을 모두 만족하면 영문자로만 구성된 문자열인지 판별할 수 있음
* 대소문자 통일 : 'aa'.lower()
* keys = set(A.keys()) | set(B.keys()) # | 연산자는 두 집합의 합집합을 의미
* a = A.get(key, 0) # get(key, 0)은 해당 key가 없으면 0을 반환
* 딕셔너리 선언 : term_dict = {}
'''

def solution(str1, str2):
    answer = 0
    
    str1_set = []
    str2_set = []
    str1_dict = {}
    str2_dict = {}
    
    for s in range(len(str1)-1): # len(str1)-1 까지 탐색하며 두개씩 자름
        tmp = str1[s:s+2]
        tmp = tmp.lower()
        if(tmp.isalpha() and tmp.isascii()): # [암기] 영문자로만 구성됐는지 확인
            str1_set.append(tmp)
    for s in range(len(str2)-1): # len(str2)-1 까지 탐색하며 두개씩 자름
        tmp = str2[s:s+2]
        tmp = tmp.lower()
        if(tmp.isalpha() and tmp.isascii()): # [암기] 영문자로만 구성됐는지 확인
            str2_set.append(tmp)

    for s in str1_set: 
        str1_dict[s] = str1_dict.get(s, 0) + 1 # [암기] 없으면 1, 있으면 +1
    
    for s in str2_set: 
        str2_dict[s] = str2_dict.get(s, 0) + 1 # [암기] 없으면 1, 있으면 +1
    
    # 합집합, 교집합 구하기 (양쪽에 있으면 min(교), max(합)에 더하기, 한쪽에 있으면 (합)에 더하기)
    keys = set(str1_dict.keys()) | set(str2_dict.keys())
    
    if len(keys) == 0:
        return 65536
    
    parent = 0
    kid = 0
    for k in keys:
        if(k in str1_dict and k in str2_dict): # 양쪽에 있으면
            tmp_min = min(str1_dict[k], str2_dict[k])
            tmp_max = max(str1_dict[k], str2_dict[k])
            parent += tmp_max
            kid += tmp_min
        else:
            parent += (str1_dict.get(k, 0)+str2_dict.get(k, 0))
    
    answer = int((kid/parent)*65536) # [암기] 파이썬 소수점 버리기 : int() 해버리면 됨 
    
    return answer