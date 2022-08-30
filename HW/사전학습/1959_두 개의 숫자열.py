t = int(input())
sum_list=[]
d= 0
sum = 0
asw_list = []

for i in range(t):
    nm_list = list(map(int,input().split(' ')))
    n_list = list(map(int,input().split(' ')))
    m_list = list(map(int,input().split(' ')))
    if len(n_list) != nm_list[0] or len(m_list) != nm_list[1]:
        print('You entered wrong')

    if nm_list[0] > nm_list[1]: # n 이 m 보다 길 때
        num = nm_list[0] - nm_list[1] + 1 
        for i in range(num):
            for j in range(len(m_list)):
                sum+=n_list[d] * m_list[j]
                d += 1
            sum_list.append(sum)
            d = i + 1
            sum = 0
    else: # m 이 n 보다 길 때 
        num = nm_list[1] - nm_list[0] + 1
        for i in range(num):
            for j in range(len(n_list)):
                sum+=m_list[d] * n_list[j]
                d += 1
            sum_list.append(sum)
            d = i + 1
            sum = 0

    sum_list.sort()
    asw_list.append(sum_list[-1])
    sum_list = []
    d= 0
    sum = 0

for i in range(t):
    print(f"#{i+1} {asw_list[i]}")

