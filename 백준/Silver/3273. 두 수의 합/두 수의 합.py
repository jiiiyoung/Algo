# 3273 두 수의 합
# 방법 1. 정렬
# 방법 2. 투포인터 시작점을 양쪽 끝으로

n = int(input())
num = list(map(int, input().split()))
target = int(input())
num.sort()

cnt = 0
i, j = 0, n-1
while 1:
    if j <= i:
        break

    sumv = num[i] + num[j]

    if sumv == target:
        cnt += 1
        i += 1
        j -= 1
    elif sumv < target:
        i += 1
    elif sumv > target:
        j -= 1

print(cnt)