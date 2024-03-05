
N = int(input())

paper = [[0]* 1001 for _ in range(1001)]

for num in range(1, N+ 1):
    y, x, height, width = map(int, input().split())

    for i in range(y, y + height):
        for j in range(x, x + width):
            paper[i][j] = num

for num in range(1, N + 1):
    cnt = 0
    for i in range(1001):
        for j in range(1001):
           if paper[i][j] == num:
               cnt += 1
    print(cnt)