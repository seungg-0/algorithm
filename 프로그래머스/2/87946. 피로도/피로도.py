# 각 던전마다 탐험을 시작하기 위한 필요한 "최소 필요 피로도", "소모 피로도"
# [최소필요피로도, 소모피로도]
# 유저가 탐험할 수 있는 최대 던전 수를 리턴

from itertools import permutations
def solution(k, dungeons):
    answer = []
    for permutation in permutations(dungeons, len(dungeons)):
        finished = 0
        energy = k
        for atleast, use in permutation:
            if energy >= atleast:
                energy -= use
                finished += 1
        answer.append(finished)
    return max(answer)