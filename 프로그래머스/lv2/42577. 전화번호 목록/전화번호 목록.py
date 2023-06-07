def solution(phone_book):
    answer = True
    
    # 실수한 부분 : for문을 두 번 돌릴 필요 없다 (효율성 생각하면서 코드 짜기)
    phone_book.sort()
    for i in range(1, len(phone_book)):
        if len(phone_book[i-1]) <= len(phone_book[i]):
                if phone_book[i-1] == phone_book[i][:len(phone_book[i-1])]:
                    answer = False
                    break
        
    return answer
