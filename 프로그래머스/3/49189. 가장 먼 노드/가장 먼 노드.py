'''
점들간 최단거리 : 다익스트라 (양방향, 가중치x)
1번 노드로부터 가장 멀리 떨어진 노드가 몇개인지 Return
다익스트라 구하고, distance 최댓값 갯수 리턴
'''

import heapq
def solution(n, edge):
    answer = 0
    INF = float("inf") # [암기]
    
    # 연결정보 저장
    graph = [[] for _ in range(n+1)]
    for link in edge:
        graph[link[0]].append(link[1])
        graph[link[1]].append(link[0])
    
    distance = [INF]*(n+1) # [암기]
    distance[1] = 0
    heap = [(0, 1)] # [암기] dis, num
    
    while heap:
        d, n = heapq.heappop(heap)
        new_distance = d+1
        for next_node in graph[n]:
            if (d+1) > distance[next_node]:
                continue
            
            # [이부분 주의]
            if new_distance < distance[next_node]:
                distance[next_node] = d+1
                heapq.heappush(heap, (d+1, next_node))
    
    distance[0] = -1
    distance.sort(reverse=True)
    answer = distance.count(distance[0])       
    
    return answer


    
    