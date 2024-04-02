n, m = map(int, input().split())

lst1 = list(map(int, input().split()))
lst2 = list(map(int, input().split()))

result = []
i, j = 0, 0
while True:
    if n == i and m == j:
        break

    if n == i:
        result.append(lst2[j])
        j += 1
    elif m == j:
        result.append(lst1[i])
        i += 1
    elif lst1[i] < lst2[j]:
        result.append(lst1[i])
        i += 1
    elif lst1[i] >= lst2[j]:
        result.append(lst2[j])
        j += 1

print(*result)