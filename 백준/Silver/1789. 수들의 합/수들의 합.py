
S = int(input())

start = 1
end = S

while end >= start:
    mid = (start + end) // 2

    current = (mid * ( mid + 1 )) // 2
    if current <= S:
        start = mid + 1

    else:
        end = mid - 1

print(end)