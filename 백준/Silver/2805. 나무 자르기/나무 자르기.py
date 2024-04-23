# 이분 탐색 - 조건의 최대, 조건의 최소
# 원하는 값과 같을 때까지 줄여나아가기
# mid를 정하고 그 값을 기준으로
# m과 같으면 결과에 mid를 저장하고 break
# m보다 크면 start를 mid+1로
# m보다 작으면 end를 mid-1로 설정

n, m = map(int, input().split())

trees = list(map(int, input().split()))

trees.sort(reverse = True)

start = 0
end = trees[0]

while start <= end:
    mid = (start + end) // 2

    cut = 0
    for tree in trees:
        if tree - mid < 0:
            break
        cut += tree - mid

    if cut >= m:
        start = mid + 1
    elif cut < m:
        end = mid - 1


print(end)

