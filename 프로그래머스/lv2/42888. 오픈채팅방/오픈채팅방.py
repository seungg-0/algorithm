# 닉네임 중복 가능
# 방에서 변경하거나 나왔다 들어오면서 변경하거나
# 키값 -> 유저 아이디

def solution(record):
    answer = []
    recored_split = []
    name_dict = {} 
    # [["Enter", "uid1234", "Muzie"], ..] 형태로 저장
    for rec in record:
        recored_split.append(rec.split(" "))
        
    # key : 아이디, value : 닉네임 형태로 저장
    for rec in recored_split:
        if rec[0] != "Leave":
            name_dict[rec[1]] = rec[2] 
            
    for rec in recored_split:
        if rec[0] == "Enter":
            answer.append(name_dict[rec[1]]+"님이 들어왔습니다.")
        elif rec[0] == "Leave":
            answer.append(name_dict[rec[1]]+"님이 나갔습니다.")
    
    return answer