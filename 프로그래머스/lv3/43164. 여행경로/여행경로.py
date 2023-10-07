def solution(tickets):
    answer = []
    tickets.sort()
    usable_ticket = [True]*len(tickets)
    
    def dfs(now_airport, journey):
        
        # 종료 조건
        if len(journey) == (len(tickets)+1):
            answer.append(journey)
            return
            
        for idx, ticket in enumerate(tickets):
            if usable_ticket[idx] and ticket[0] == now_airport:
                usable_ticket[idx] = False # 티켓 사용 처리
                dfs(ticket[1], journey+[ticket[1]])
                usable_ticket[idx] = True
    
    dfs('ICN', ['ICN'])
    return answer[0]