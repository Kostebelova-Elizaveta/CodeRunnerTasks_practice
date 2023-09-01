# Быстрая сортировка (QuickSort)
def quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quicksort(left) + middle + quicksort(right)

num = int(input())
input_str = input()
arr = [int(x) for x in input_str.split()]

help = []
for i in range(num):
    if num != 1:
        if i == 0:
            help.append(-arr[i + 1])
        elif i == num - 1:
            help.append(arr[i - 1])
        else:
            help.append(arr[i - 1] - arr[i + 1])
    else:
        help.append(0)

sorted_help = quicksort(help)
reverse = sorted_help[::-1]

print(' '.join(str(e) for e in reverse))