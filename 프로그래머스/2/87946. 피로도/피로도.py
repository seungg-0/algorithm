# 일정 피로도를 사용해 던전 탐험 가능
# 각 던전마다 탐험 시작하기 위해 필요한 "최소 필요 필요도", 소료 필요 피로도 (탐험후 소진)
# 최대한 던전 많이 탐험, 탐험 던전 수 return

# 소모 가장 적은거 탐험하는게 이득

from itertools import permutations

def solution(k, dungeons):
    answer = []
    
    for permu in permutations(dungeons, len(dungeons)):
        powers = k
        cnt = 0
        for minimum, power in permu:
            if powers >= minimum:
                powers -= power
                cnt += 1
        answer.append(cnt)
    
    
    return max(answer)