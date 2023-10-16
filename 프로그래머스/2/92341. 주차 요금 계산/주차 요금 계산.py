# 입차된 후 출차 내역 없다면, 23:59에 출차된 것으로 간주
# 기본 시간 이하라면, 기본 요금
# 기본 시간 초과하면, 기본 요금 + 초과 단위 시간(올림)마다 단위 요금
# 딕셔너리?
# fees : 기본 시간, 기본 요금, 단위 시간, 단위 요금

def solution(fees, records):
    answer = []
    carNum_hour = {} # 차량 번호, 입차 시간
    carNum_fee = {} # 차량 번호, 총 요금
    carNum_mins = {} # 차량 번호, 총 주차 시간
    
    def calcMins(in_hour, out_hour): # 주차 시간 계산하는 함수
        in_h, in_min = in_hour.split(":")
        out_h, out_min = out_hour.split(":")
        hs = int(out_h)-int(in_h)
        mins = int(out_min)-int(in_min)
        return hs*60 + mins
        
    def calcFee(total): # 주차 요금 계산하는 함수
        if total <= fees[0]: # 기본 시간 이하라면
            return fees[1]
        else: 
            if (total-fees[0])%fees[2] == 0:
                return fees[1] + int((total-fees[0])/fees[2])*fees[3]
            else:
                return fees[1] + int((total-fees[0])/fees[2])*fees[3] + fees[3]
        
    for record in records:
        hour, carNum, inout = record.split(" ")
        if (carNum_hour.get(carNum) == None) or len(carNum_hour[carNum]) == 0: # 입차
            carNum_hour[carNum] = [hour]
        else: # 출차
            in_hour = carNum_hour[carNum]
            parking_mins = calcMins(in_hour[0], hour)
            if carNum_mins.get(carNum) == None:
                carNum_mins[carNum] = parking_mins
            else:
                carNum_mins[carNum] += parking_mins
            carNum_hour[carNum] = [] # 출차한 차 입차내역 딕셔너리에서 삭제
    
    # 출차처리 안된 차량 23:59으로 출차 처리
    for carNum, hour in carNum_hour.items():
        if len(hour) != 0:
            parking_mins = calcMins(hour[0], "23:59")
            if carNum_mins.get(carNum) == None:
                carNum_mins[carNum] = parking_mins
            else:
                carNum_mins[carNum] += parking_mins
    
    for carNum, total_mins in carNum_mins.items():
        fee = calcFee(total_mins)
        carNum_fee[carNum] = fee
        
    carNum_fee = dict(sorted(carNum_fee.items(), key=lambda x:int(x[0])))
    
    return list(carNum_fee.values())