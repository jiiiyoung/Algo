# 팬케익 먹기
# 가로 x, 세로 y, 높이 h
# 팬케이크 먹는 횟수 n
# 케이크는 변에 평행하여 자르고 1cm씩 자른다.
# 팬케익을 D번 먹은 후 남은 팬케익 부피의 최대값 구하기


T = int(input())

for _ in range(T):
    input()
    x, y, h, n = map(int, input().split())

    cake = [x, y, h]

    for i in range(n):
        cake.sort()
        cake[-1] -= 1


    print(cake[0]*cake[1]*cake[2])

