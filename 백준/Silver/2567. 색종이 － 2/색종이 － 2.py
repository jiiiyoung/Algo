'''
# 둘레에서 겹치는 부분 둘레 탐색해 비교(안나옴)

def dfs(level):
    global comprange

    if level == 2:
        if comprange[0][0] < comprange[1][0] < comprange[0][0] + 10 and comprange[0][1] < comprange[1][0] < comprange[0][1] + 10:   # 각 조합들 중 겹치는 상황 고려하기1
            compare1(comprange[0], comprange[1])
        elif comprange[0][0] < comprange[1][0] < comprange[0][0] + 10 and comprange[0][1] < comprange[1][0] + 10 < comprange[0][1] + 10: # 각 조합들 중 겹치는 상황 고려하기1
            compare2(comprange[0], comprange[1])
        return


    for i in range(n):
        comprange[level] = range_lst[i]
        dfs(level + 1)

def compare1(range1, range2):
    global double

    ylen = range1[0]+10 - range2[0] + 1  # 0부터 시작이기 때문에 + 1 해주기
    xlen = range1[1]+10 - range2[1] + 1

    double += (ylen + xlen) * 2

def compare2(range1, range2):
    global double

    ylen = range1[0] + 10 - range2[0] + 1
    xlen = range2[1] - range1[1] + 1

    double += (ylen + xlen) * 2

# 색종이 둘레 구하기
n = int(input())

paper = [[0]*101 for _ in range(101)]

range_lst = []
for _ in range(n):
    c, r = map(int, input().split())
    range_lst += [[c, r]]   # 색종이의 범위를 리스트로 만들기

alllen = 10 * 4 * n
double = 0
comprange=[[] for _ in range(2)]
dfs(0)
length = alllen - double

print(length)

'''






# 맞은 답 _ 방향배열로 풀이
def counting(y, x):

    length = 0

    directy = [-1, 1, 0, 0]
    directx = [0, 0, -1, 1]

    for i in range(4):
        dy = y + directy[i]
        dx = x + directx[i]

        if dy < 0 or dx < 0 or dy >= 100 or dx >= 100:
            continue

        if paper[dy][dx]:
            length += 1

    return length


def paint(y, x):

    for i in range(10):
        for j in range(10):
            paper[y + i][x + j] = 1

# 색종이 둘레 구하기
n = int(input())

paper = [[0]*101 for _ in range(101)]

range_lst = []
for _ in range(n):
    c, r = map(int, input().split())
    range_lst += [[c, r]]   # 색종이의 범위를 리스트로 만들기
    paint(c, r)   # 색칠하기

cnt = 0
for i in range(101):
    for j in range(101):
        if paper[i][j] == 0:
            cnt += counting(i, j)

print(cnt)

