# 1620 나는야 포켓몬 마스터 이다솜
import sys
m, n = map(int, sys.stdin.readline().split())
pokemon_dic = {}
name_dic = {}
for i in range(m):
    pokemon = sys.stdin.readline().replace('\n', '')
    pokemon_dic[i+1] = pokemon
    name_dic[pokemon] = i+1

for i in range(n):
    temp = sys.stdin.readline().replace('\n', '')

    if temp.isdigit():
        print(pokemon_dic[int(temp)])
    else:
        print(name_dic[temp])
