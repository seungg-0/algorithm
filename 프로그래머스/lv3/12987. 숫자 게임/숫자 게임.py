def solution(A, B):
    answer = 0
    
    A.sort(reverse = True)
    B.sort(reverse = True)
    B_start = 0
    for i in range(len(A)): # 0 1 2 3
        if A[i] >= B[i-B_start]:
            # print(A[i], B[i-B_start])
            B_start += 1
        elif A[i] < B[i-B_start]:
            # print(A[i], B[i])
            answer += 1
    
    
    return answer