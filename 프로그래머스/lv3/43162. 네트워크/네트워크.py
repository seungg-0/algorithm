def solution(n, computers):
    answer = 0
    links = []
    
    for i in range(len(computers)-1):
        for j in range(1+i, len(computers[0])):
            if computers[i][j] == 1 and i != j:
                links.append((i, j))
    
    # 연결된 노드가 없는 경우
    if len(links) == 0: 
        return len(computers)

    visited = [False]*len(links)
    
    def dfs(net):
        for idx, link in enumerate(links):
            if ((link[0] in net) or (link[1] in net)) and not visited[idx]:
                visited[idx] = True
                dfs(net+[link[0], link[1]])
       
    for i in range(len(links)):
        if not visited[i]:
            visited[i] = True
            dfs([links[i][0], links[i][1]]) # dfs가 완료되면 (하나의 네트워크 탐색 완료되면)
            answer += 1 # 네트워크 갯수 하나 증가
            
    # 링크로 연결되지 않은 단일 네트워크 수를 세어준다.
    set_list = []
    for a, b in links:
        set_list.append(a)
        set_list.append(b)
    set_list = set(set_list)
    
    # 노드 여러개 가진 네트워크 + 단일 네트워크
    answer += (len(computers) - len(set_list)) 
    return answer
