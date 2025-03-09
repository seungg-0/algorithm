import sys
input = sys.stdin.readline

n = int(input())
d = [0]*300
dp = [0]*300

for i in range(n):
    d[i] = int(input())

dp[0] = d[0]
dp[1] = d[0]+d[1]
dp[2] = max(d[2]+d[1], d[2]+d[0])

for i in range(3, n):
    dp[i] = max(d[i]+d[i-1]+dp[i-3], d[i]+dp[i-2])

print(dp[n-1])