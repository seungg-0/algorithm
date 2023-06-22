# 딕셔너리 사용
# 가장 먼저 탈락한 사람, 몇 번째 차례에 탈락하는지 출력 -> 마지막에 계산 가능

def solution(n, words):
    answer = []
    words_dict = {}
    end = words[0][-1]
    words_dict[words[0]] = 1
    words = words[1:]
    cnt = 1
    flag = False
    
    for word in words:
        if end == word[0] and word not in (words_dict.keys()):
            words_dict[word] = 1
            end = word[-1]
            cnt += 1
        else:
            flag = True
            cnt += 1
            break
    if not flag:
        return [0, 0]
    if (cnt % n) == 0:
        answer1 = n
    else:
        answer1 = cnt%n
    if (cnt%n) == 0:
        answer2 = cnt//n
    else:
        answer2 = cnt//n + 1
    answer.append(answer1)
    answer.append(answer2)
    return answer