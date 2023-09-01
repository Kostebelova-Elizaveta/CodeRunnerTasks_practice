n = int(input())  # Считываем размерность массива
arr = list(map(int, input().split()))  # Считываем элементы массива и преобразуем их в список целых чисел

# Считаем количество повторений для каждого элемента
frequencies = {}
for num in arr:
    frequencies[num] = frequencies.get(num, 0) + 1

# Сортируем массив по количеству повторений и, в случае равенства, по возрастанию
for i in range(len(arr)-1):
    for j in range(len(arr)-i-1):
        if frequencies[arr[j]] == frequencies[arr[j+1]]:
            if arr[j]>arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
        elif frequencies[arr[j]] < frequencies[arr[j+1]]:
            arr[j], arr[j+1] = arr[j+1], arr[j]
sorted_arr = arr

for i in range(len(arr)):
    if i!=0:
        if not sorted_arr[i]==sorted_arr[i-1]:
            print(sorted_arr[i], frequencies[sorted_arr[i]])
    else:
        print(sorted_arr[i], frequencies[sorted_arr[i]])
print("Answer:", ' '.join(map(str, sorted_arr)))