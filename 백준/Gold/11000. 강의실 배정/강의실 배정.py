# 11000 강의실배정
# S에 시작해서 T에 끝나는 N개의 수업
# 최소의 강의실을 사용해서 모든 수업을 가능하게 한다.

# 우선순위 큐를 이용하여 정렬하기(기준1 끝나는시간, 기준2 시작시간)
#
# 시작과 끝을 비교하여 강의실을 쓸 수 있으면 그 전 강의를 빼고 현재 강의 추가
# 만약 모든 조건이 성립되지 않는다면, 리스트에 추가
# 마지막 강의가 끝난 후 리스트의 길이로 값 계산
import heapq

n = int(input())

classtime = []
for i in range(n):
    heapq.heappush(classtime, tuple(map(int, input().split())))

# result는 끝나는 시간을 비교하여 넣기
result =[]
heapq.heappush(result, heapq.heappop(classtime)[1])

while classtime:
    s, e = heapq.heappop(classtime)

    # result의 첫 항(끝나는시간)이 s보다 작거나 같으면
    # result에 첫 항 빼고 e넣기
    # result의 첫 항이 s보다 크면 result에 e추가
    time = heapq.heappop(result)
    if s >= time:
        heapq.heappush(result, e)
    else:
        heapq.heappush(result, time)
        heapq.heappush(result, e)

print(len(result))