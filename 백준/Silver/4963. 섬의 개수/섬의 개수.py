# bfs를이용하여 탐색한 섬은 0으로 변경하여 flag 1을 리턴하여 count 1 하는 함수 만들기
# 이중for문으로 탐색하기


def search(y, x):  # 탐색한 섬을 중복체크 하지 않게 하는 함수

    directy = [1, -1, 0, 0, 1, 1, -1, -1]
    directx = [0, 0, 1, -1, -1, 1, 1, -1]

    for i in range(8):
        dy = y + directy[i]
        dx = x + directx[i]

        if dy < 0 or dx < 0 or dy >= n or dx >= m:
            continue

        if map_arr[dy][dx] == 0: continue

        if map_arr[dy][dx] == 1:
            map_arr[dy][dx] = 0
            search(dy, dx)
    return


while 1:
    m, n = map(int, input().split())

    if m == 0 and n == 0:
        break
    map_arr = [list(map(int, input().split())) for _ in range(n)]

    count = 0 # 섬의 개수 출력하는 함수
    for i in range(n):
        for j in range(m):
            if map_arr[i][j] != 0:
                search(i, j)
                count += 1

    print(count)

    