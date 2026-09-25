def solution(today, terms, privacies):
    answer = []
    
    # 딕셔너리 선언 변수 = {}
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
        
        # 문제 잘 읽기
        if((month+cm)>12):
            year += (cy+1)
            month = month+cm-12
        else:
            year += cy
            month += cm
        
        # 코드 작성 전에 인덱스 및 대소비교 확실하게 검증하고 짜기
        if (tyear*10000+tmonth*100+tday>=year*10000+month*100+day):
            answer.append(idx+1)
    
    return answer