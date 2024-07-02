#문제 4. 숫자야구 ( # 2503 )

count = int(input())

hint = [list(map(int, input().split())) for _ in range(count)]

answer = 0
# 나올 수 있는 모든 경우의 수
for a in range(1,10):
    for b in range(1,10):
        for c in range(1,10): 
    
            # 동일한 숫자가 있을 경우 continue
            if a == b or b == c or a == c:
                continue

            cnt = 0    
            for arr in hint:
                # 힌트에 있는 숫자, 스트라이크, 볼 추출
                num = arr[0]
                strike = arr[1]
                ball = arr[2]

                # num에서 첫째자리, 둘째자리, 셋째자리 분리 시킨 뒤 a,b,c와 비교
                first = num // 100
                second = (num % 100) // 10
                third = num % 10
                                
                ball_count = 0
                strike_count = 0

                # 스트라이크인 경우(위치와 숫자 둘 다 일치)
                if first == a:
                    strike_count += 1
                if second == b:
                    strike_count += 1
                if third == c:
                    strike_count += 1
                
                # 볼인 경우(숫자만 일치, 위치가 다를 경우)
                if first == b or first == c:
                    ball_count += 1
                if second == a or second == c:
                    ball_count += 1
                if third == a or third == b:
                    ball_count += 1

                # num과 abc의 결과가 일치할 경우 카운트 세기
                if ball == ball_count and strike == strike_count:
                    cnt += 1
            
            # 결과가 매번 일치했다면 경우의 수에 포함
            if cnt == count:
                answer += 1

print(answer)