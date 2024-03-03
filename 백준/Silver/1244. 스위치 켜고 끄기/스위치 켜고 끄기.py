def man(num):
    for i in range(switch_n):
        if (i + 1) % (num + 1) == 0:
            switch[i] = int(not switch[i])

def woman(num):

    switch[num] = int(not switch[num])

    i = 1
    while num - i >= 0 and num + i < switch_n:

        if switch[num - i] == switch[num + i]:
            switch[num - i] = int(not switch[num - i])
            switch[num + i] = int(not switch[num + i])
        else:
            break

        i += 1

switch_n = int(input())
switch = list(map(int, input().split()))

n = int(input())

for i in range(n):
    code, number = map(int,input().split())

    if code == 1:
        man(number-1)
    else:
        woman(number-1)

for i in range(switch_n):
    if i != 0 and i % 20 == 0:
        print()
    print(switch[i], end = ' ')