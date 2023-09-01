def countSort(input):
    # создаем пустой словарь для хранения частот элементов списка
    freq = {}

    # сохраняем различные значения во входном списке как ключ и
    # их соответствующие счетчики как значения
    for x in input:
        freq[x] = freq.get(x, 0) + 1

    for i in range(len(input)-1):
        for j in range(len(input)-i-1):
            if input[j]>input[j+1]:
                input[j], input[j+1] = input[j+1], input[j]
    sorted_input = input
    
    for i in range(len(input)):
        if i!=0:
            if not sorted_input[i]==sorted_input[i-1]:
                print(sorted_input[i][0], freq[sorted_input[i]])
        else:
            print(sorted_input[i][0], freq[sorted_input[i]])


n = int(input())
input_list = []
a_input = input().split()
for i in range(n):
    a = int(a_input[i])
    input_list.append((a, 0))

countSort(input_list)

print("Answer:", ' '.join(str(e[0]) for e in input_list))