# DFS 풀이
# 일단, 이 문제와 같이 "최단거리"를 구하는 문제는 BFS로 푸는게 더 간편하다 ! 항상 뭘 쓰는게 더 좋을지 생각 먼저 하기.
# 처음 정답률 20%로 좀 시간이 걸렸는데, if 부분에서 return을 해주는게 아니라 그냥 answer값을 업데이트 해주면 됐었다.

def solution(begin, target, words):
    answer = 1e9
    visited = [False]*len(words)
    
    def dfs(word, change_cnt):
        nonlocal answer
        if word == target:
            answer = min(answer, change_cnt)
        
        for idx, change_word in enumerate(words):
            cnt = 0
            for i in range(len(word)):
                if word[i] != change_word[i]:
                    cnt += 1
            if cnt == 1 and not visited[idx]:
                visited[idx] = True
                dfs(change_word, change_cnt+1)
                visited[idx] = False

    dfs(begin, 0)
    if answer == 1e9:
        return 0
    else:
        return answer
