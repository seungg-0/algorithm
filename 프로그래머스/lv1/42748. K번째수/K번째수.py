def solution(array, commands):
    answer = []
    
    for list in commands:
        s, e, n = list
        arr = array[s-1:e]
        arr.sort()
        answer.append(arr[n-1])
    
    return answer