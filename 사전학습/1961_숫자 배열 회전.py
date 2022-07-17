T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
final_list = []
n_list = [0]
for test_case in range(1, T + 1):
    n = int(input())
    n_list.append(n)
    # n * n 행렬 받아오기
    matrix = []
    for _ in range(n):
        # 문자열로 붙여줄것이기 때문에 문자 타입으로 넣어줌
        matrix.append(list(map(str, input().split())))

    # 각도마다 회전한 모양 담을 리스트
    # 각 행을 붙여서 print해야 하기 떄문에 빈 문자열 넣어준다.
    # ex) 1행 :  ['1', '2', '3'] -> '123'
    r_90 = ['' for _ in range(n)]
    r_180 = ['' for _ in range(n)]
    r_270 = ['' for _ in range(n)]

    for i in range(n):
        for j in range(n):
            r_90[n-i-1] = matrix[j][n-i-1] + r_90[n-i-1]
            r_180[i] += matrix[n-i-1][n-j-1]
            r_270[n-i-1] = matrix[n-j-1][i] + r_270[n-i-1]

    for i in range(n):
        # 90도 180도 270도의 i행 출력
        final_list+=r_90[i], r_180[i], r_270[i]

start = 0
count = 0
check = 0
n_list
for i in range(start,len(final_list),3):
    out = final_list[start:start+3]
    if count == n_list[check]:
        print(f'#{check+1}')
        count = 0
        check += 1
    if out != []:
        print(*out)
        count += 1
    start += 3
    
