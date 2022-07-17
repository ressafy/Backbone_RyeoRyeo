T = int(input())
# # 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
# final_list = []

# for test_case in range(1, T + 1):
#     row_list = []
#     height_list = []
#     nm_list = list(map(int, input().split(' ')))
#     for i in range(nm_list[0]):
#         line_list = list(map(int, input().rstrip().split(' ')))
#         row_list.append(line_list)


# I failed to solve so I searched about this q and I understood about it
final = []

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T+1) :
    nm_list  = list(map(int, input().split()))
    area = [ [0]* nm_list[0] for _ in range(nm_list[0]) ] # 리스트 컴프리헨션으로 2차원 배열을 만든다. - 미리 만들어서 시간 감축
    for i in range(nm_list[0]) :
        area[i] = list(map(int, input().split())) # 입력 받는대로 값을 넣어준다.

    kill = []
    for i in range(nm_list[0]-nm_list[1]+1) :
        for j in range(nm_list[0]-nm_list[1]+1) :
            count = 0
            for k in range(nm_list[1]) :
                for l in range(nm_list[1]) :
                    count += area[i+k][j+l]   # 인접한 4칸의 합들을 전부 모은다.
            kill.append(count)
    kill.sort() # 정렬 후 가장 큰 값을 꺼낸다.
    final.append(kill[-1])
for i in range(len(final)):
    print(f"#{i + 1} {final[i]}")