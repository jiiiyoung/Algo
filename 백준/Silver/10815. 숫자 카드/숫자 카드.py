import sys


n = int(sys.stdin.readline())
cards = set(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))

for i in numbers:
    if i in cards:
        print(1, end =' ')
    else:
        print(0, end =' ')
print()
