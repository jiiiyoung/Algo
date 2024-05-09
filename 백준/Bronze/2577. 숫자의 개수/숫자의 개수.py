A = int(input())
B = int(input())
C = int(input())
dat = [0]*10

sum = A*B*C
real_sum = str(sum)

for i in range(len(real_sum)):
    dat[int(real_sum[i])] += 1

for j in dat:
    print(j)
