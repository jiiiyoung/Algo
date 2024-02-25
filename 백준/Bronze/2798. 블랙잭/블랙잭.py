# Dfs 써서 합 구해서 조건 달기, abs의 최소값구하기
def dfs(level, sumv):
    global minv, diffmin

    if level == 3:
        if sumv <= m:
            diff = abs(m - sumv)
            if diff < diffmin:
                minv = sumv
                diffmin = diff

        return

    for i in range(n):
        if used[i] != 1:
            used[i] = 1
            dfs(level+1, sumv + card[i])
            used[i] = 0


n, m = map(int, input().split())
card= list(map(int, input().split()))
minv, diffmin = [21e8]*2
used = [0]*n
dfs(0, 0)
print(minv)




