def dfs(s, level):
    global result

    if s == end:
        result = level
        return

    for k in family[s]:
        if visited[k] != True:
            visited[k] = True
            dfs(k, level + 1)

n = int(input())
start, end = map(int, input().split())
m = int(input())

family = [[] for _ in range(n+1)]
for i in range(m):
    parent, child = map(int, input().split())
    family[child].append(parent)
    family[parent].append(child)

visited = [False] * (n+1)
visited[start] = True
result = -1
dfs(start, 0)

print(result)


