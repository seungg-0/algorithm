# 내림차순 정렬, 앞에서부터 하나씩 세면서 그 값이랑 작거나 같아지는게 있으면 출력
def solution(citations):
    citations.sort(reverse = True)
    count, answer = 0, 0
    for i in range(max(citations), -1, -1):
        for j in citations:
            if i <= j:
                count += 1
        if count >= i:
            answer = i
            break
        else:
            count = 0
        
    return answer