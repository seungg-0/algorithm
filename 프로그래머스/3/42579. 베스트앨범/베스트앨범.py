# 장르 별로 가장 많이 재생된 노래 두 개씩
# 1. 속한 노래가 많이 재생된 장르 먼저 (장르 선택)
# 2. 장르 내에서 많이 재생된 노래 (장르 내 노래 선택)
# 3. 재생수 같으면 고유 번호가 낮은 노래 먼저 (고유 번호로 선택)

def solution(genres, plays):
    answer = []
    genres_dict = {} # key : 장르 value : 고유번호(인덱스)
    plays_dict = {} # key : 고유번호(인덱스) value : 재생횟수
    genres_plays_dict = {} # key : 장르 value : 속한 노래들의 총 재생 수
    for idx in range(len(genres)):
        plays_dict[idx] = plays[idx]
        if genres_plays_dict.get(genres[idx]) == None:
            genres_plays_dict[genres[idx]] = plays[idx]
        else:
            genres_plays_dict[genres[idx]] += plays[idx]
        
        if genres_dict.get(genres[idx]) == None:
            genres_dict[genres[idx]] = [idx]
        else:
            genres_dict[genres[idx]].append(idx)
    
    genres_plays_dict = dict(sorted(genres_plays_dict.items(), key=lambda x:x[1], reverse=True))

    for genre in genres_plays_dict.keys(): # 한 장르당 두개 answer에 저장
        idx_plays = []
        for i in genres_dict[genre]:
            idx_plays.append([i, plays_dict[i]]) # [고유번호, 재생횟수] 저장
        idx_plays.sort(key=lambda x:(-x[1], x[0])) # 재생된 횟수 많은것, 재생된 횟수가 같다면 고유번호 작은것
        if len(idx_plays) == 1:
            answer.append(idx_plays[0][0])
        else:
            answer.append(idx_plays[0][0])
            answer.append(idx_plays[1][0])
    
    return answer