'''
numbers (사용할 수 있는 숫자들 담긴)
타겟 숫자 만드는 방법 수 return
'''

def solution(numbers, target):
    answer = 0
    
    def dfs(idx, total):
        nonlocal answer # [암기] nonlocal
        # 종료조건
        if(idx==len(numbers)):
            if(total==target):
                answer += 1
            return
        
        # 두 갈래로 재귀 호출 해야 함 (두갈래 호출 아래와 같이)
        # 숫자를 더하는 경우
        dfs(idx+1, total+numbers[idx])
        # 숫자를 빼는 경우
        dfs(idx+1, total-numbers[idx])
        
    dfs(0, 0)
    return answer