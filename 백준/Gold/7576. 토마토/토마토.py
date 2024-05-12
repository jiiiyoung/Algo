from collections import deque

m, n = map(int, input().split())

box = [list(map(int, input().split())) for _ in range(n)]

q = deque()

for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            q.append([i, j, 0])

direct = [
        [-1, 1, 0, 0], # x좌표
        [0, 0, 1, -1], # y좌표
        ]

result = 0
while q:
    y, x, day = q.popleft()

    if day > result:
        result = day

    for i in range(4):
        dy = y + direct[1][i]
        dx = x + direct[0][i]

        if dx < 0 or dy < 0 or dx >= m or dy >= n:
            continue

        if box[dy][dx] == -1 or box[dy][dx] == 1:
            continue

        if box[dy][dx] == 0:
            box[dy][dx] = 1
            q.append([dy, dx, day + 1])


for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            result = -1

print(result)