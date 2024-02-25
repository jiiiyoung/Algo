paper = [[0]*100 for _ in range(100)]

n = int(input())

for i in range(n):
    range1, range2 = map(int, input().split())
    for i in range(range1, range1+10):
        paper[i][range2:range2+10] = [1]*10

sumv = 0
for i in range(100):
    for j in range(100):
        sumv += paper[i][j]
print(sumv)
