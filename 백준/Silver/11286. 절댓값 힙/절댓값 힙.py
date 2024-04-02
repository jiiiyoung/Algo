import sys
import heapq

n = int(sys.stdin.readline())
result = []
for i in range(n):
    integer = int(sys.stdin.readline())
    if integer == 0:
        if len(result) == 0:
            print(0)
        else:
            print(heapq.heappop(result)[1])
    else:
        heapq.heappush(result, (abs(integer), integer))