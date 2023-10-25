def solution(word):
    answer = 0
    alphabet = ['A', 'E', 'I', 'O', 'U']
    
    cnt = 0
    def dfs(w):
        nonlocal answer, cnt
    
        if w == word:
            answer = cnt
        if len(w) == 5:
            return
    
        for a in alphabet:
            cnt += 1
            dfs(w+a)
    
    dfs("")
    return answer