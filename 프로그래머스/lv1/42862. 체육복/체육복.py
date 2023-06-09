# 실수한 부분 : 1. 로직은 sort 가정하고 짰는데 sort 안해줌 (로직, 문제 조건 확인하기) 2. for문 돌릴 때 리스트 크기 변하게 짬

def solution(n, lost, reserve):
    answer = 0
    lost.sort()
    reserve.sort()

    # 1. 여벌 가져온 학생 중 도난당한 학생 체크
    reserve_list = []
    for i in reserve:
        if i in lost:
            lost.remove(i)
            continue
        else:
            reserve_list.append(i)
    
    # 2. 체육복 유무 알 수 있는 having 
    having = [True for _ in range(n+1)]

    for i in lost:
        having[i] = False

    for i in reserve_list:
        if i == 1:
            if having[i+1] == False:
                having[i+1] = True
        elif i == n:
            if having[i-1] == False:
                having[i-1] = True
        else:
            if having[i-1] == False:
                having[i-1] = True
            elif having[i+1] == False:
                having[i+1] = True

    having[0] = False
    answer = having.count(True)

    return answer
