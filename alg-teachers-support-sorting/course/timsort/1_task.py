def timsort(arr):

    # Определяем размер блока для сортировки
    min_run = 32

    # Разделяем массив на блоки и сортируем их
    runs = split_into_runs(arr, min_run)
    for i in range(len(runs)):
        print("Part", str(i) + ':', ' '.join(str(e) for e in runs[i]))

    # Слияние отсортированных блоков
    sorted_arr = merge_runs(runs)

    return sorted_arr


def insertion_sort(arr, left=0, right=None):
    if right is None:
        right = len(arr) - 1

    for i in range(left + 1, right + 1):
        key_item = arr[i]
        j = i - 1
        while j >= left and arr[j] > key_item:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key_item

    return arr


def merge(left, right):
    if not left:
        return right

    if not right:
        return left

    if left[0] < right[0]:
        return [left[0]] + merge(left[1:], right)

    return [right[0]] + merge(left, right[1:])


def merge_runs(runs):
    while len(runs) > 1:
        runs.append(merge(runs.pop(0), runs.pop(0)))

    return runs[0]


def split_into_runs(arr, min_run):
    runs = []
    length = len(arr)
    i = 0

    while i < length:
        run = arr[i:i + min_run]
        insertion_sort(run)
        runs.append(run)
        i += min_run

    return runs


n = int(input())
arr = []
a_input = input().split()
for i in range(n):
    a = int(a_input[i])
    arr.append(a)

sorted_arr = timsort(arr)
print("Answer:", ' '.join(str(e) for e in sorted_arr))
