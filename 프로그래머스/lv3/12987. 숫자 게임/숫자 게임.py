# B가 가진 숫자 중 큰 수부터 사용
# B의 가장 큰 수랑 A의 가장 큰 수를 비교했을 때 A가 크거나 같으면 A의 두번째 큰 수와 B의 가장 큰 수 비교

def solution(A, B):
    answer = 0
    A.sort(reverse = True)
    B.sort(reverse = True)
    B_start = 0
    for i in range(len(A)):
        if A[i] >= B[i-B_start]:
            B_start += 1
        else:
            answer += 1
    return answer
