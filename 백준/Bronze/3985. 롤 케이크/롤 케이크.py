# 가장 개수 많은 롤케이크 idx구하는 조건
# 같은 경우 가장 작은 값 조건 추가

L = int(input())

n = int(input())

cake = [0]*(L+1)

reserve = []
for _ in range(n):
    a, b = map(int, input().split())
    reserve += [[a, b]]

maxv = -21e8
for i in range(n-1, -1, -1):
    num1, num2 = reserve[i]
    cnt = num2 - num1 + 1
    cake[num1:num2+1] = [i+1]*cnt
    if cnt >= maxv:
        maxv = cnt
        maxidx = i+1

print(maxidx)

pnum = 1
cnt = 0
pieces = -21e8
for num in range(L, -1, -1):
    if cake[num] != 0:
        if cake[num] == pnum:
            cnt += 1
            if pieces <= cnt:
                pieces = cnt
                maxpeople = cake[num]
        else:
            pnum = cake[num]
            cnt = 1

print(maxpeople)
