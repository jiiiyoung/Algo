# 시작점 =  [n//2][n//2]
# 토네이도가 도는 방향 구하는 방법 생각하기 -> 2번 돌때마다 +1씩, (0,0)일때 끝내기 (방향배열 for문 사용)
# 모래 구하는 것 : 해당 좌표에서 방향배열 + 가중치로 비율 지정 (방향배열에 해당하는 가중치 리스트도 선언하여 for문에 돌리기)
# 좌표 벗어나면 continue 하기 전에 값 계산하기

def sand(y, x, d):
    global sumv

    weight = [0.05, 0.1, 0.07, 0.02, 0.01, 0.01, 0.07, 0.02, 0.1]

    if d == 0:
        directy = [0, 1, 1, 2, 1, -1, -1, -2, -1, 0]
        directx = [-2, -1, 0, 0, 1, 1, 0, 0, -1, -1]
    elif d == 1:
        directy = [2, 1, 0, 0, -1, -1, 0, 0, 1, 1]
        directx = [0, 1, 1, 2, 1, -1, -1, -2, -1, 0]
    elif d == 2:
        directy = [0, -1, -1, -2, -1, 1, 1, 2, 1, 0]
        directx = [2, 1, 0, 0, -1, -1, 0, 0, 1, 1]
    elif d == 3:
        directy = [-2, -1, 0, 0, 1, 1, 0, 0, -1, -1]
        directx = [0, 1, 1, 2, 1, -1, -1, -2, -1, 0]

    current = arr[y][x]
    if current == 0:
        return

    alpha = 0
    for i in range(10):
        dy = y + directy[i]
        dx = x + directx[i]

        if i == 9:
            send_sand = current - alpha
        else:
            send_sand = int(current * weight[i])

        if dy < 0 or dx < 0 or dy >= n or dx >= n:
            sumv += send_sand
        else:
            arr[dy][dx] += send_sand
        alpha += send_sand

    arr[y][x] = 0
    return


n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]

tornado_y = [0, 1, 0, -1]
tornado_x = [-1, 0, 1, 0]

sy, sx = [n//2]*2
length = 0
flag = 0
sumv = 0
while True:
    for i in range(4):
        if i == 0 or i == 2:
            length += 1

        for l in range(length):

            sy += tornado_y[i]
            sx += tornado_x[i]

            sand(sy, sx, i)
            if sy == 0 and sx == 0:
                print(sumv)
                flag = 1
                break
        if flag:
            break
    if flag:
        break
