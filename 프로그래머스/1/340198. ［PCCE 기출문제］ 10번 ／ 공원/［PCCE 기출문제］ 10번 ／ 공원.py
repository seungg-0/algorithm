# 문제 잘못 이해함
# mats 안에 있는 숫자중에 정답이 있음 
# -1 발견할 때마다 mats 길이만큼 가능한지 확인 (정사각형 모양으로)

def solution(mats, park):
    answer = -1
    
    pwidth = len(park[0])
    plength = len(park)
    
    mats.sort(reverse=True)
    for mat in mats:
        for r in range(0, plength-mat+1): 
            for c in range(0, pwidth-mat+1):
                if park[r][c] == "-1":
                    possible = True
                    for i in range(r, r+mat): 
                        for j in range(c, c+mat):
                            if park[i][j] != "-1":
                                possible = False
                        if not possible:
                            break
            
                    if possible:
                        answer = max(answer, mat)
                        # break
    
    return answer