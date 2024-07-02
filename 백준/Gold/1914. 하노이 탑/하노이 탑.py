n = int(input())

def hanoi(disks, start, end, sub):
    if disks == 1:                      # 종료조건 : disk가 1개인 경우, 시작장대에서 마지막 장대로 옮기고 종료
        print(start, end)
    else:                               # 문제 정의
        hanoi(disks-1, start, sub, end) # n-1개의 디스크를 처음 장대에서 이웃 장대로 이동
        hanoi(1, start, end, sub)       # 1개의 디스크를 처음 장대에서 마지막 장대로 이동
        hanoi(disks-1, sub, end, start) # n-1개의 디스크를 이웃 장대에서 마지막 장대로 이동


print(pow(2,n)-1)
if n <= 20:
    hanoi(n,1,3,2)