N = int(input())


stick = []
for i in range(N):
    stick += [int(input())]

maxv = stick[-1]
cnt = 1
for i in range(N-2, -1, -1):
    if maxv < stick[i]:
        cnt += 1
        maxv = stick[i]

print(cnt)