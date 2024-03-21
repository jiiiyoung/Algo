# 길이가 짧은 것 부터
# 길이가 같은 경우 포함된 숫자의 합이 작은 것 부터
# 숫자가 알파벳보다 더 전에(사전순)


def getsum(string):
    sumv = 0
    for st in string:
        if st.isdigit():
            sumv += int(st)
    return sumv

n = int(input())
lst = []
for i in range(n):
    lst.append(input())

lst = sorted(lst, key = lambda x: (len(x), getsum(x), x))
for i in lst:
    print(i)
