# 1~n
# 파기해야 할 개인정보 번호들 구하기 
# 모든 달 28일까지 있음 

def solution(today, terms, privacies):
    answer = []
    
    term_dict = {}
    

    tyear, tmonth, tday = map(int, today.split("."))

    
     # 약관 정보 dict 로 저장
    for term in terms:
        k, v = term.split(" ")
        term_dict[k] = int(v)
    
    for idx, privacy in enumerate(privacies):
        date, key = privacy.split(" ")
        year, month, day = map(int, date.split("."))
        
        # 유효기간 최대 100달 
        ms = term_dict[key]
        cy = ms//12
        cm = ms%12
        print(term_dict[key])
        print(cy, cm, year, month, day)
        
        if((month+cm)>12):
            year += (cy+1)
            month = month+cm-12
        else:
            year += cy
            month += cm
            

        print(tyear, tmonth, tday, year, month, day)
        print(tyear*10000+tmonth*100+tday, year*10000+month*100+day)
        if (tyear*10000+tmonth*100+tday>=year*10000+month*100+day):
            answer.append(idx+1)

    
    return answer