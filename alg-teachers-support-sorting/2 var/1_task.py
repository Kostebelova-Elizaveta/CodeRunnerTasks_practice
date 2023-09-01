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
help = []
input_str = input()
arr = [int(x) for x in input_str.split()]

for i in range(num):
    if arr[i] % 2 == 0:
        help.append(arr[i])

sorted_help = quicksort(help)
print(' '.join(str(e) for e in sorted_help))


