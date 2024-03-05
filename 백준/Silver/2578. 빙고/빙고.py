### 숫자 찾아서 방문표시하는 함수,
### 빙고가 된 것이 있는지 확인하는 check 함수

def visit(num):
    flag = 0
    for i in range(5):
        for j in range(5):
            if binggo[i][j] == num:
                visited[i][j] = 1
                check(i, j)
                flag = 1
                break
        if flag: break

    if result >= 3:
        return 1
    else:
        return 0


def check(y, x):
    global result

    # row
    if visited[y][:] == [1]*5:
        result += 1

    # col
    col = []
    for i in range(5):
        col += [visited[i][x]]
    if col == [1]*5:
        result += 1

    # 대각선
    if y == x:
        diag = []
        for i in range(5):
            diag += [visited[i][i]]

        if diag == [1] * 5:
            result += 1

    # 역대각선
    if y + x == 5-1:
        rediag = []
        for i in range(5):
            rediag += [visited[i][4 - i]]

        if rediag == [1] * 5:
            result += 1

    return result

binggo = [list(map(int, input().split())) for _ in range(5)]

visited = [[0]*5 for _ in range(5)]

numbers = []
for _ in range(5):
    numbers += list(map(int, input().split()))

result = 0
for i in range(len(numbers)):
    if visit(numbers[i]):
        print(i+1)
        break


