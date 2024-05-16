def dfs(start):
    global cnt

    for air in airplane[start]:
        if visited[air] != True:
            visited[air] = True
            cnt += 1
            dfs(air)


T = int(input())

for _ in range(T):
    n, m = map(int, input().split())

    airplane = [[] for _ in range(n+1)]
    for i in range(m):
        temp1, temp2 = map(int, input().split())
        airplane[temp1].append(temp2)
        airplane[temp2].append(temp1)


    visited = [False]*(n+1)
    cnt = 0
    for i in range(1, n+1):
        if visited[i] != True:
            visited[i] = True
            dfs(i)
    print(cnt)