# 후보키의 갯수 찾기
from itertools import product

def solution(relation):
    answer = 0
    relations = [1, 0]
    uniques = []
    for case in product(relations, repeat=len(relation[0])):
        case = list(case)

        tuples = set()
        for val in relation:
            key = ""
            for idx,c in enumerate(case):
                if c == 1:
                    key += '+'+val[idx]
            tuples.add(key)
        if len(tuples) == len(relation): # 유일성 만족 
            answer += 1
            uniques.append(case)
        
    indexes = []
    for unique in uniques:
        tmp = []
        for i in range(len(unique)):
            if unique[i] == 1:
                tmp.append(i)
        indexes.append(tmp)
    
    def isIncluded(lis1, lis2):
        count = 0
        for i in lis1:
            if i in lis2:
                count += 1
        if count == len(lis1):
            return True
        else:
            return False
    
    indexes.sort(key = lambda x:len(x))
    deleted = [False]*len(indexes)
    for i in range(len(indexes)):
        for j in range(i+1, len(indexes)):
            if len(indexes[i]) == 0 or len(indexes[j]) == 0:
                continue
            if isIncluded(indexes[i], indexes[j]) and (not deleted[j]):
                deleted[j] = True
                answer -= 1   
    
    return answer
