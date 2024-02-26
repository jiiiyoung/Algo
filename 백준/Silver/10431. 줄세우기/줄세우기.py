T = int(input())
for tc in range(1, T+1):
    n, *tall = map(int, input().split())

    cnt = 0
    for i in range(len(tall)):
        for j in range(i, len(tall)):
            if tall[i] > tall[j]:
                tall[i], tall[j] = tall[j], tall[i]
                cnt += 1


    print(f'{n} {cnt}')