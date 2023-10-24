

def solution(begin, target, words):
    answer = 1e9
    visited = [False]*len(words)
    if begin == target:
        return 0
    
    def changeable(first, second):
        cnt = 0
        for i in range(len(first)):
            if first[i] != second[i]:
                cnt += 1
        if cnt == 1:
            return True
        else:
            return False
    
    def dfs(w, change_num):
        nonlocal answer
        if w == target:
            answer = min(change_num, answer)
            return
        
        for idx, word in enumerate(words):
            if not visited[idx] and changeable(w, word):
                visited[idx] = True
                dfs(word, change_num+1)
                visited[idx] = False
    
    dfs(begin, 0)
    if answer == 1e9:
        return 0  
    
    return answer