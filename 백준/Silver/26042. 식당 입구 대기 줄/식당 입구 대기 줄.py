Testcase = int(input())

waiting = []
maxv = -21e8
maxnum = 21e8
for _ in range(Testcase):
    temp = list(map(int, input().split()))

    if temp[0] == 2:
        waiting.pop(0)
    elif temp[0] == 1:
        waiting += [temp[1]]

    n = len(waiting)

    if maxv <= n:
        if maxv == n:
            if maxnum > waiting[-1]:
                maxnum = waiting[-1]
        else:
            maxv = n
            maxnum = waiting[-1]

print(maxv, maxnum)
