import re # [암기]
from itertools import permutations # [암기]
def solution(expression):
    answer = 0
    expressions = re.split(r'([+*-])', expression)
    operands = set()
    for s in expressions:
        if(s in ['*', '-', '+']):
            operands.add(s)
    
    for permu in permutations(operands, len(operands)):
        tmp_expressions = expressions.copy() # [암기] 리스트 복사할떈 이렇게 해야 함 
        
        for oper in permu:
            idx = 0
            while(idx<len(tmp_expressions)):
                if(tmp_expressions[idx]==oper):
                    left = int(tmp_expressions[idx-1])
                    right = int(tmp_expressions[idx+1])
                    if(oper=='+'):
                        result = left+right
                        tmp_expressions[idx-1:idx+2] = [str(result)] # [암기] [idx-1:idx+2] 처럼 범위있을 때 값 할당하려면 [] 로 묶어줘야 함 [result]
                    if(oper=='-'):
                        result = left-right
                        tmp_expressions[idx-1:idx+2] = [str(result)] # [암기] [idx-1:idx+2] 처럼 범위있을 때 값 할당하려면 [] 로 묶어줘야 함 [result]
                    if(oper=='*'):
                        result = left*right
                        tmp_expressions[idx-1:idx+2] = [str(result)] # [암기] [idx-1:idx+2] 처럼 범위있을 때 값 할당하려면 [] 로 묶어줘야 함 [result]
                    idx = 0
                else:
                    idx += 1
                        
                        
        answer = max(answer, abs(int(tmp_expressions[0])))
    

    
    return answer