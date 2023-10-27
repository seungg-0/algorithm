# def solution(n, costs):
#     answer = 0
#     costs.sort(key=lambda x:x[2]) # 가격 기준 오름차순 정렬
#     link = set([costs[0][0]])
    
#     while len(link) < n:
#         for node1, node2, cost in costs:
#             if node1 in link and node2 in link: # 둘 다 이미 연결되어 있다면
#                 continue
#             if node1 in link or node2 in link: # 둘 중 하나는 연결되어 있지 않고 하나는 연결되어 있다면
#                 link.update([node1], [node2])
#                 answer += cost
#                 break
#     return answer

# 최소의 비용으로 모든 섬이 서로 통행 가능하도록 필요한 최소 비용 리턴

def solution(n, costs):
    answer = 0
    costs = sorted(costs, key = lambda x:x[2])
    connected = [0]*n
    connected[costs[0][0]] = 1
    
    while sum(connected) < n:
        for node1, node2, cost in costs:
            if connected[node1] and connected[node2]: # 둘 다 연결
                continue
            elif connected[node1] or connected[node2]:
                connected[node1] = 1
                connected[node2] = 1
                answer += cost
                break

    return answer