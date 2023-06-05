def solution(skill, skill_trees):
    answer = 0
    skill_dict = {}
    for i in range(len(skill)):
        skill_dict[skill[i]] = i

    for skill_tree in skill_trees:
        tmp = {}
        for i in range(len(skill_tree)):
            if skill_tree[i] in skill:
                tmp[skill_tree[i]] = i
        
        if len(skill) == 1:
            answer += 1
        else:
            # skill의 key값들 쭉 뽑는다
            # key값들로 tmp의 value값 찾아서 리스트에 저장
            # 오름차순이면 answer += 1
            skill_keys = skill_dict.keys()
            tmp_list = []
            flag = False
            is_possible = True
            for i in skill_keys:
                if tmp.get(i) == None:
                    flag = True
                else:
                    if flag == True:
                        is_possible = False
                        break
                    else:
                        tmp_list.append(tmp[i])
            
            if is_possible == False:
                answer = answer
            else:
                is_sorted = all(tmp_list[i] < tmp_list[i+1] for i in range(len(tmp_list)-1))
                if is_sorted:
                    answer += 1
    return answer

