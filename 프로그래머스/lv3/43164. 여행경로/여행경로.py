# ICN 출발

def solution(tickets):
    answer = []
    tickets.sort()
    visited = [False for _ in range(len(tickets))]
    
    def dfs(start, route):
        if len(route) == (len(tickets)+1):
            answer.append(route)
            return
        for idx, ticket in enumerate(tickets):
            if not visited[idx] and start == ticket[0]:
                visited[idx] = True
                dfs(ticket[1], route+[ticket[1]])
                visited[idx] = False
    
    dfs("ICN", ["ICN"])
    answer = answer[0]
    return answer