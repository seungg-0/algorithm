# 붕대 감기
# t초 동안 붕대, 1초마다 x만큼 체ㅔ력 회복, 연속 성공시 y만큼 추가회복
# 최대보다 커질 순 없음
# 끝까지 생존할 수 있는지 (남은체력 return 죽으면 -1)

'''
step1 for문으로 마지막 공격 시간까지 순회하기
step2 처음 체력에서 attack 들어올 때까지 붕대 감기
'''

def solution(bandage, health, attacks):
    nowhealth = 0
    # [암기] 이중배열 첫번째값 기준으로 정렬 (key=lambda x:(x[0], -x[1]))
    nowhealth = health
    for idx, attack in enumerate(attacks):
        cont = 0
        if idx != 0:
            for i in range(attacks[idx][0]-attacks[idx-1][0]-1): # 공격 들어올 때까지 반복
                cont += 1
                nowhealth = min(nowhealth+bandage[1], health)
                print(nowhealth, attack)
                if(cont == bandage[0]):
                    nowhealth = min(nowhealth+bandage[2], health) 
                    cont = 0
        else:
            for i in range(attack[0]): # 공격 들어올 때까지 반복
                cont += 1
                nowhealth = min(nowhealth+bandage[1], health)
                print(nowhealth, attack)
                if(cont == bandage[0]):
                    nowhealth = min(nowhealth+bandage[2], health) 
                    cont = 0
        
        # 공격 받기 
        nowhealth -= attack[1]
        print(nowhealth, attack)
        if(nowhealth<=0):
            return -1
    
    
    return nowhealth