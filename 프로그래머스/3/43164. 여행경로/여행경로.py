'''
항상 ICN에서 출발
방문하는 공항 경로를 배열에 담아 리턴 
모두 사용해야 함 (모두 방문)
알파벳 순서 

DFS
오름차순 정렬, ICN으로 시작
항공권 인덱스로 방문처리(사용처리) 모두 사용해야 함.
'''

def solution(tickets):
    visited = [False]*(len(tickets))
    tickets.sort()
    
    def dfs(departure, route):
        
        if(len(route)==len(tickets)+1):
            return route
        
        for idx, ticket in enumerate(tickets):
            depart = ticket[0]
            arrive = ticket[1]
            if(departure==depart and not visited[idx]):
                visited[idx] = True
                result = dfs(arrive, route + [arrive])
                # 완성된 경로를 찾았다면 반환
                if result is not None:
                    return result
                visited[idx] = False
    
    answer = dfs("ICN", ["ICN"])
    return answer