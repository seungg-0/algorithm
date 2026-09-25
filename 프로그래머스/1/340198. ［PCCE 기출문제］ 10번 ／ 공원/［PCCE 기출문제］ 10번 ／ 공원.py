def solution(mats, park):
    answer = -1
    
    width = len(park[0])
    length = len(park)
    mats.sort(reverse = True)
    
    for mat in mats:
        for r in range(0, length-mat+1):
            for c in range(0, width-mat+1):
                
                possible = True
                for i in range(r, r+mat):
                    for j in range(c, c+mat):
                        if park[i][j] != "-1":
                            possible = False
                            break
                    if not possible:
                        break
                
                if possible:
                    return mat

    return answer