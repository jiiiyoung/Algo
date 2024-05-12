m, n, h = map(int, input().split())

box = []
for _ in range(h):
    box.append([list(map(int, input().split())) for _ in range(n)])

from collections import deque
q = deque()
for k in range(h):
    for i in range(n):
        for j in range(m):
            if box[k][i][j] == 1:
                q.append([k, i, j, 0])
direct = [
        [-1, 1, 0, 0, 0, 0], # x좌표 (가로 왼, 오)
        [0, 0, 1, -1, 0, 0], # y좌표 (세로 앞, 뒤)
        [0, 0, 0, 0, 1, -1], # z좌표(위, 아래)
        ]

result = 0
while q:
    z, y, x, day = q.popleft()

    if day > result:
        result = day

    for i in range(6):
        dz = z + direct[2][i]
        dy = y + direct[1][i]
        dx = x + direct[0][i]

        if dx < 0 or dy < 0 or dz < 0 or dx >= m or dy >= n or dz >= h:
            continue

        if box[dz][dy][dx] == -1 or box[dz][dy][dx] == 1:
            continue

        if box[dz][dy][dx] == 0:
            box[dz][dy][dx] = 1
            q.append([dz, dy, dx, day + 1])


for k in range(h):
    for i in range(n):
        for j in range(m):
            if box[k][i][j] == 0:
                result = -1

print(result)