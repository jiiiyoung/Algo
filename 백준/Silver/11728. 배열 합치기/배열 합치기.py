n, m = map(int, input().split())

lst1 = list(map(int, input().split()))
lst2 = list(map(int, input().split()))

result = lst1 + lst2
result.sort()

print(*result)