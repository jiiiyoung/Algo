# 10828

# push X : 정수 X를 스택에 넣는 연산
# pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력 (정수 없으면 -1출력)
# size : 스택에 들어있는 정수의 개수를 출력
# empty : 스택이 비어있으면 1, 아니면 0
# top : 스택의 가장 위에 있는 정수 출력(스택에 정수 없으면 -1 출력)
import sys

n = int(sys.stdin.readline())
stack = []
for _ in range(n):
    temp = list(sys.stdin.readline().split())
    category = temp[0]
    l = len(stack)
    if category == 'push':
        stack.append(temp[1])
    elif category == 'pop':
        if l:
            print(stack.pop())
        else:
            print(-1)
    elif category == 'size':
        print(l)
    elif category == 'empty':
        if l:
            print(0)
        else:
            print(1)
    elif category == 'top':
        if l:
            print(stack[l-1])
        else:
            print(-1)