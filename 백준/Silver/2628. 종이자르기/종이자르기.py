# row , col , 각각 부여하고 정렬해서 가장 처음에 0, 가장 마지막에 크기 더해서 간격이 가장 큰 값 구해 곱하기


c, r = map(int, input().split())

n = int(input())
row, col = [0, r], [0, c]
for _ in range(n):
    p, n = map(int, input().split())

    if p == 0:
        row += [n]
    else:
        col += [n]

row.sort()
col.sort()

maxrow, maxcol = [-21e8] * 2
for i in range(len(row)-1):
    diff = row[i+1] - row[i]
    if maxrow < diff:
        maxrow = diff

for i in range(len(col)- 1):
    diff = col[i+1] - col[i]
    if maxcol < diff:
        maxcol = diff


print(maxrow * maxcol)
