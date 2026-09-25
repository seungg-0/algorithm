'''
점들간 최단거리 : 다익스트라
양방향, 가중치0
마을1, 마을2, 가중치
1번 마을에 있는 음식점이 K이하의 시간에 배달이 가능한 마을의 개수 return
'''

import heapq
def solution(N, road, K):
    answer = 0

    INF = float("inf")
    distance = [INF]*(N+1)
    
    # 연결그래프 만들기 ([마을, 가중치])
    graph = [[] for _ in range(N+1)]
    for r in road:
        t1 = r[0]
        t2 = r[1]
        dis = r[2]
        graph[t1].append([t2, dis])
        graph[t2].append([t1, dis])
    
    # 다익스트라 
    heap = [(1, 0)] # [암기] 형태
    distance[1] = 0
    while heap:
        node, dist = heapq.heappop(heap)
        for link in graph[node]:
            next_node = link[0]
            dis = link[1]
            next_dist = dist+dis
            if(next_dist>distance[next_node]):
                continue
            elif(next_dist<distance[next_node]):
                
                distance[next_node] = next_dist
                heapq.heappush(heap, (next_node, next_dist))

    for d in distance:
        if(d<=K):
            answer+=1
    
    return answer