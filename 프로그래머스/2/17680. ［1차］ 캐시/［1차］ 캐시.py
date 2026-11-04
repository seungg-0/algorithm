'''
캐시 크기에 따른 실행시간 측정 프로그램 작성 

캐시 크기, 도시이름 배열 입력
! 대소문자 구분 안함 (s.lower())
LRU 구현 : 고정 크기의 queue 사용

step0 : let 함수로 캐시 크기 확인, queue 이용해서 캐시 관리 (초반 캐시 크기 도달할 때 까지만 len 확인)
step1 : 도시이름 캐시에 하나씩 넣고, popleft() (단, hit시 remove())
       , 넣는 도시 queue에 있는지 확인하고 있으면 +1, 없으면 +5
       
* [LRU 구현 시 주의 (hit시)]
queue.remove(city) : 기존 도시 제거
queue.append(city) : 가장 최근 사용 위치로 이동
를 활용해야 함. hit시 해당 도시 맨 오른쪽으로 보내줘야 해서
'''

from collections import deque
def solution(cacheSize, cities):
    answer = 0
    
    queue = deque()
    if(cacheSize == 0):
        return len(cities*5)
    for city in cities:
        city = city.lower()
        if(len(queue)<cacheSize):
            if(city in queue):
                answer += 1
                queue.remove(city)
                queue.append(city)
            else:
                answer += 5
                queue.append(city)
        else:
            if(city in queue):
                answer += 1
                queue.remove(city)
                queue.append(city)
            else:
                answer += 5
                queue.popleft()
                queue.append(city)
                
    return answer