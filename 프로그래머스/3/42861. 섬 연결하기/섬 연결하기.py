def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x:x[2]) # 가격 기준 오름차순 정렬
    link = set([costs[0][0]])
    
    while len(link) < n:
        for node1, node2, cost in costs:
            if node1 in link and node2 in link: # 둘 다 이미 연결되어 있다면
                continue
            if node1 in link or node2 in link: # 둘 중 하나는 연결되어 있지 않고 하나는 연결되어 있다면
                link.update([node1], [node2])
                answer += cost
                break
    return answer
