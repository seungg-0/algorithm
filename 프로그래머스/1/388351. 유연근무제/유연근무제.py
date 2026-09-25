def solution(schedules, timelogs, startday):
    answer = 0

    # 1:(6,7) 2:(5,6), 3:(4,5), 4:(3,4), 5:(2,3) 6:(1,2), 7:(7,1)
    # 비교 제외 : 7-startday, (7-startday)+1
    if startday == 7:
        passes = [0, 6]
    else :
        passes = [7-startday-1, 7-startday]
        
    for i, timelog in enumerate(timelogs):
        reward = True
        for j in range(7):
            if j in passes:
                continue
            # 지각
            limit = schedules[i]
            hour = int(str(limit)[:-2])
            minute = int(str(limit)[-2:])+10
            if(minute>=60):
                hour += 1
                minute -= 60
            if (int(str(timelog[j])[:-2])*100+int(str(timelog[j])[-2:]) > hour*100+minute):
                reward = False
        if reward:
            answer+=1

    return answer