from itertools import combinations
from collections import Counter # 항목의 갯수를 셀 때 사용하는 클래스 Counter

def solution(orders, course):
    answer = []
    for k in course: # 코스 종류 하나씩 탐색 (몇 개 코스인지)
        candidates = []
        for menu_li in orders: # 주문 하나씩 탐색
            for li in combinations(menu_li, k): # 주문한 메뉴들 k개(k개 코스) 조합 만들기
                res = ''.join(sorted(li)) # 조합 하나의 문자로 변환, 정렬해서 저장
                candidates.append(res)
        sorted_candidate = Counter(candidates).most_common() # 각 조합 몇개 있는지 세어서 내림차순 정렬
        answer += [menu for menu, cnt in sorted_candidate if cnt > 1 and cnt == sorted_candidate[0][1]] # 가장 첫 번째(주문 수 가장 많은 것) 주문수와 같으면 answer에 더하기
        
    answer.sort()
                
    return answer