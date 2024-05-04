# 2512 예산
# 가능한한 최대의 예산을 배정
# 가능하면 요청한 금액 그대로 배정
# 불가능하면 정수 상한액 계산해 그 이상의 예산 요청은 상한액으로 이하는 그 예산으로

n = int(input())
budgets = list(map(int, input().split()))
S = int(input())

budgets.sort()
if sum(budgets) <= S:
    result = budgets[-1]
else:
    start = 1
    end = budgets[-1]

    while start <= end:
        mid = (start + end) // 2

        current = 0
        for budget in budgets:
            if budget > mid:
                current += mid
            else:
                current += budget

        if current <= S:
            start = mid + 1
        else:
            end = mid - 1

    result = end

print(result)
