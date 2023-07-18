# def solution(s, n):
#     answer = ''
#     gap = False
#     for i in range(len(s)):
#         if s[i] == ' ':
#             gap = True
#             continue
#         if s[i] == 'z':
#             answer += chr(ord('a')+n-1)
#         elif s[i] == 'Z':
#             answer += chr(ord('A')+n-1)
#         else:
#             answer += chr(ord(s[i])+n)
#     if gap:
#         tmp = ''
#         for i in range(len(answer)):
#             if i == 0:
#                 tmp += answer[i]
#             else:
#                 tmp += ' '
#                 tmp += answer[i]
#         answer = tmp
#     return answer

def solution(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():
            s[i]=chr((ord(s[i])-ord('A')+ n)%26+ord('A'))
        elif s[i].islower():
            s[i]=chr((ord(s[i])-ord('a')+ n)%26+ord('a'))
 
    return "".join(s)
 