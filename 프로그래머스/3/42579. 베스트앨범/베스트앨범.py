'''
장르 별로 가장 많이 재생된 노래 두개씩 모아 베스트 앨범 출시
노래 고유 번호 
1. 많이 재생된 장르 먼저
2. 장르 내 많이 재생된 노래 
3. 재생 횟수 같으면 고유 번호가 낮은 노래 먼저

dict
고유번호, 장르, 재생횟수
장르 - 고유번호
고유번호 - 횟수
(1) 장르 순서 정하기 (k:장르 v:총재생횟수) (순회하면서 장르별 횟수 합산, dict 저장, 비교) 
(2) k:고유번호, v:횟수 (v오름차순, k내림차순 정렬 / 2개 선택)
'''

def solution(genres, plays):
    answer = []
    n = len(genres)
    genr_idx = {}
    idx_play = {}
    genr_total = {}
    
    for i in range(n):
        genr_idx[genres[i]] =  genr_idx.get(genres[i], []) + [i]
        idx_play[i] = plays[i]
        # 형태 암기
        genr_total[genres[i]] = genr_total.get(genres[i], 0)+plays[i]

    genr_total = dict(sorted(genr_total.items(), key=lambda x:-x[1])) # 많이 재생된 순서로 정렬 (내림차순)
    
    # 2. 장르 내 많이 재생된 노래 
    # 3. 재생 횟수 같으면 고유 번호가 낮은 노래 먼저
    for g in genr_total.keys(): # 장르 하나씩 꺼내기 (많이 재생된 장르부터)
        tmp_dict = {}
        for i in genr_idx[g]: # 해당 장르에 속한 고유번호들
            tmp_dict[i] = idx_play[i] # key : 고유번호, value : 재생횟수 
        
        tmp_dict = dict(sorted(tmp_dict.items(), key=lambda x : (-x[1], x[0])))
        cnt = 0
        for idx in tmp_dict.keys(): # 장르별 두개 뽑기
            answer.append(idx)
            cnt+=1
            if cnt == 2:
                break
            
    
    return answer
