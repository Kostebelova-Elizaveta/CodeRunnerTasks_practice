def timsort(arr):

    # Определяем размер блока для сортировки
    min_run = 32

    # Разделяем массив на блоки и сортируем их
    runs = split_into_runs(arr, min_run)
    for i in range(len(runs)):
        print("Part", str(i)+':', ' '.join(str(e) for e in runs[i]))

    # Слияние отсортированных блоков
    sorted_arr = merge_runs(runs)
    return sorted_arr


def insertion_sort(arr):
    for i in range(1, len(arr)):
        key_item = arr[i]
        j = i - 1
        while j >= 0 and compare_squares(arr[j], key_item):
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key_item

    return arr


def merge(left, right):
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if (left[i]*left[i] < right[j]*right[j]):
            result.append(left[i])
            i += 1
        else:
            if (left[i]>right[j]):
                result.append(left[i])
                i += 1
            else:
                result.append(right[j])
                j += 1

    result.extend(left[i:])
    result.extend(right[j:])
    return result


def merge_runs(runs):
    while len(runs) > 1:
        left = runs.pop(0)
        right = runs.pop(0)
        merged = merge(left, right)
        runs.append(merged)

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


def compare_squares(a, b):
    return a * a > b * b or (a * a == b * b and a < b)


n = int(input())
arr = []
a_input = input().split()
for i in range(n):
    a = int(a_input[i])
    arr.append(a)

sorted_arr = timsort(arr)
print("Answer:", ' '.join(str(e) for e in sorted_arr))
