# # 한 번에 한 단어 변환
# # words에 있는 단어로만 변환

# def solution(begin, target, words):
#     answer = []
#     visited = [False]*len(words)
    
#     def dfs(word, change_cnt):
        
#         # 종료 조건 (target으로 바뀌면)
#         if word == target:
#             answer.append(change_cnt)
#             return
        
#         else:
#             for idx, change_word in enumerate(words):
#                 # if not visited[idx]:
#                 cnt = 0
#                 for i in range(len(word)):
#                     if word[i] != change_word[i]:
#                         cnt += 1
#                 if cnt == 1 and not visited[idx]:
#                     visited[idx] = True
#                     # tmp = word
#                     # word = change_word
#                     dfs(change_word, change_cnt+1)
#                     # word = tmp
#                     visited[idx] = False


#     dfs(begin, 0) 
#     answer.sort()
#     if len(answer) > 1:
#         return answer[0]
#     else:
#         return 0




def solution(begin, target, words):
    answer = 24700000000
    flag = 0
    m = len(words)
    ch = [0] * m
    def dfs(word,target,val):
        nonlocal flag, m, answer
        if word == target:
            flag = 1
            answer = min(answer,val)
        else:
            for i in range(m):
                cnt = 0
                #한 번에 한 개의 알파벳만 바꿀 수 있는 조건 체크
                for j in range(len(word)):
                    if word[j] != words[i][j]: 
                        cnt += 1
                if ch[i] == False and cnt == 1:
                    ch[i] = True
                    dfs(words[i],target,val + 1)
                    ch[i] = False
    dfs(begin,target,0)
    if flag:
        return answer
    else:
        return 0