'''
4번에서 시작
A : 도착 6
B : 도착 2
A, B 귀가하는 데 소요되는 예상 최저 택시요금 계산
가중치0, 양방향

4, A, B 지점에서 다익스트라
4 - K - A
    K - B 
비용 합산하면 됨
'''

import heapq
def solution(n, s, a, b, fares):
    INF = float("inf")
    answer = INF
    
    global distance_s, distance_a, distance_b
    distance_s = [INF]*(n+1)
    distance_a = [INF]*(n+1)
    distance_b = [INF]*(n+1)
    
    graph = [[] for _ in range(n+1)]
    
    for fare in fares: # 도로 연결정보 저장
        n1 = fare[0]
        n2 = fare[1]
        dis = fare[2]
        graph[n1].append([n2, dis])
        graph[n2].append([n1, dis])
    
    dijkstra(graph, s, fares, distance_s)
    dijkstra(graph, a, fares, distance_a)
    dijkstra(graph, b, fares, distance_b)
    
    for k in range(1, n+1):
        s_k = distance_s[k]
        k_a = distance_a[k]
        k_b = distance_b[k]
        answer = min(answer, s_k+k_a+k_b)

    return answer

def dijkstra(graph, start, fares, distance):
    heap = [(start, 0)] # node, dist
    distance[start] = 0
    while(heap):
        node, dist = heapq.heappop(heap)
        for g in graph[node]:
            n_node = g[0]
            n_dist = g[1]
            if(dist+n_dist>distance[n_node]):
                continue
            elif(dist+n_dist<distance[n_node]):
                distance[n_node] = dist+n_dist
                heapq.heappush(heap, (n_node, distance[n_node]))

    return