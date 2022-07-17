
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
final_list = []

for test_case in range(1, T + 1):
    nm_list = []
    row_list = []
    height_list = []
    new_list = []
    check_list = []
    count = 0
    flag = True
    final = 0
    #1이 있는 곳이 빈 곳 0은 막힌 곳
    nm_list = list(map(int, input().split(' ')))
    for i in range(nm_list[0]):
        line_list = list(map(int, input().rstrip().split(' ')))
        row_list.append(line_list)
    for i in range(nm_list[0]):
        for j in range(nm_list[0]):
            new_list.append(row_list[j][i])
        height_list.append(new_list)
        new_list = []
    # 여기까지가 세로줄과 가로줄의 배열을 따로 만들어준 부분
    # 정상 작동 확인
    a = nm_list[0] - 1
    for i in range(nm_list[0]):
        for j in range(nm_list[0]):
            if row_list[i][j] == 1:
                count += 1
                flag = True
            elif row_list[i][j] == 0:
                check = count
                count = 0
                flag = False
                check_list.append(check)
                check = 0

            if  j == a:

                check_list.append(count)
                count = 0
                
        


        if nm_list[1] in check_list:
            for i in check_list:
                if i == nm_list[1]:
                    final += 1
        check_list = []
    # 여기까지가 1이 k번 나온 줄이 있나 판단하는 줄

    for i in range(nm_list[0]):
        for j in range(nm_list[0]):
            if height_list[i][j] == 1:
                count += 1
                flag = True
            elif height_list[i][j] == 0:
                check = count
                count = 0
                flag = False
                check_list.append(check)
                check = 0

            if  j == a:
                check_list.append(count)
                count = 0
                
        


        if nm_list[1] in check_list:
            for i in check_list:
                if i == nm_list[1]:
                    final += 1
        check_list = []
    # 여기까지가 1이 k번 나온 줄이 있나 판단하는 줄
    final_list.append(final)
    final = 0
    row_list = []
    height_list = []




for i in range(len(final_list)):
    print(f"#{i+1} {final_list[i]}")

# # 출력부



# 생각해낸 풀이 방안: 먼저 세로줄과 가로줄의 빈 칸의 배열을 따로 만든다. 
# 이 후 1의 길이가 k 만큼인 것들을 각 리스트에서 카운트해준다. 