# 2178 미로탐색

from collections import deque
n, m = map(int, input().split())

mirro = [list(map(int, input())) for _ in range(n)]
visited = [[n*m]*m for _ in range(n)]

q = deque()

q.append([0, 0, 1])
direct = [[1, -1, 0, 0],
          [0, 0, 1, -1]]

visited = [[999999]*m for _ in range(n)]

visited[0][0] = 1
while q:
    y, x, level = q.popleft()

    for i in range(4):
        dy = y + direct[0][i]
        dx = x + direct[1][i]

        if dy < 0 or dx < 0 or dy >= n or dx >= m:
            continue

        if mirro[dy][dx] == 0:
            continue

        if visited[dy][dx] > level + 1:
            q.append([dy, dx, level + 1])
            visited[dy][dx] = level + 1

print(visited[n-1][m-1])
