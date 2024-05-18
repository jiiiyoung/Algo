# 하나씩 더해지면 그 값은 넘기기


N = int(input())

arrow = list(map(int, input().split()))
cnt = 0
bucket = [0]*1000001
for i in range(N):
    if bucket[arrow[i]] == 0:
        bucket[arrow[i]-1] += 1
    else:
        bucket[arrow[i]] -= 1
        bucket[arrow[i]-1] += 1

print(sum(bucket))


