# # 모든 자릿수 감소하면 감소하는 수
# # N번째 감소하는 수 구하기
# # 없다면 -1 출력
#
# import sys
# input = sys.stdin.readline
#
# n = int(input())
# desc_nums = [[] for _ in range(6)]
# desc_nums[0] = [1]*9
# print(desc_nums)
#
# # 이중 리스트로 감소하는 수 갯수 저장 (행인덱스+1 : 자릿수, 시작하는 숫자의 첫 번째 숫자 정보
# for i in range(1, 6):
#     for j in range(10-i):
#         if j == 0:
#             desc_nums[i].append(1)
#         else:
#             desc_nums[i].append(desc_nums[i][j-1]+desc_nums[i-1][j])
#
# total = sum(map(sum, desc_nums))
# if total < n:
#     print(-1)

# 총 가능한 자릿수는 6가지이고, 자릿수마다 만들 수 있는 감소하는 수에 규칙이 있는 것 같아 갯수 만들기에 성공
# 입력받은 N번째 처리하는 알고리즘 구상 못함
# 구글링 시도한 결과 문제 자체를 잘못 접근 ....

from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())
desc_num = []

for i in range(1, 11): # 1~10개 고르는 조합 구하기
    for j in combinations(range(10), i):
        # 고르고 리스트화, 내림차순 정렬, 한 문자로 만들기(''.join하려면 str로 변환 필요), 정수로 바꾸기 (*복습)
        desc_num.append(int(''.join(list(map(str, reversed(list(j)))))))

if n >= len(desc_num):
    print(-1)

else:
    desc_num.sort() # 오름차순 정렬
    print(desc_num[n])

# 아주 깔끔하고 완벽한 풀이다. 복습 꼭 하기 !


