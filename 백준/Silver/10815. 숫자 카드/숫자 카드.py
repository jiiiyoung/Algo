n = int(input())
cards = set(map(int, input().split()))

m = int(input())
numbers = list(map(int, input().split()))

for i in numbers:
    if i in cards:
        print(1, end =' ')
    else:
        print(0, end =' ')
print()