# 4889 안정적인 문자열
from collections import deque
def parenthesis(string):

    stack = []

    while string:
        temp = string.popleft()
        if temp == '{':
            stack.append(temp)
        else: # '}'일 때
            if len(stack) == 0:
                stack.append(temp)
            else: # stack에 {가 있는지 비교하기
                temp2 = stack.pop()
                if temp2 == '}':
                    stack.append(temp)
                    stack.append(temp2)

    return stack

def change(st):

    cnt = 0

    length = len(st)
    for i in range(0, length - 1, 2):
        if st[i] == st[i+1]:
            cnt += 1
        else:
            cnt += 2

    return cnt

num = 0
while 1:
    num += 1
    string = deque(input())

    if string[0] == '-':
        break

    st = parenthesis(string)
    length = len(st)

    if length != 0:
        length = change(st)

    print(f"{num}. {length}")
