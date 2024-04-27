# 칸토어 집합
def division(string):
    global answer

    length = len(string)

    if length == 1:
        answer = ['-']
        return answer

    start = length // 3

    answer = division(string[:start]) + [' '] * start + division(string[start*2:])
    return answer
while 1:
    try:
        n = int(input())
    except:
        break

    cantor = ['-'] * (3 ** n)
    answer = []
    division(cantor)
    print(*answer, sep='')

