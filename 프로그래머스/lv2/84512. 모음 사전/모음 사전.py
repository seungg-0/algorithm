def solution(word):
    answer = 0
 
    word_list = []
    words = "AEIOU"
 
    # 모든 단어조합의 경우를 찾는 함수
    def all_word(cnt, w):
        if cnt == 5:
            return
 
        for i in range(len(words)):
            word_list.append(w + words[i])
            all_word(cnt + 1, w + words[i])
 
 
    all_word(0, "")
 
 
    return word_list.index(word) + 1