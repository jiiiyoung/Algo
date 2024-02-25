N, B = input().split()
N = list(N[::-1])
B = int(B)

sumv = 0
for i in range(len(N)):

    if N[i].isdigit():
        N[i] = int(N[i])
    else:
        N[i] = ord(N[i]) - ord('A') + 10

    sumv += int(N[i]*(B**i))

print(sumv)