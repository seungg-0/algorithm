def solution(participant, completion):
    answer = ''

    participant_dict = {}
    completion_dict = {}
    for x in participant:     
        participant_dict[x] = participant_dict.get(x, 0) + 1
    for x in completion:
        completion_dict[x] = completion_dict.get(x, 0) + 1

    for key, value in completion_dict.items():
        participant_dict[key] -= value
    
    answer = [key for key, value in participant_dict.items() if value > 0]

    return ''.join(answer)
