import math
def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = math.ceil(len(arr) / 2)
    left = arr[:mid]
    right = arr[mid:]

    print("Merging arr:", ' '.join(map(str, arr)))

    left = merge_sort(left)
    right = merge_sort(right)

    return merge(left, right)


def merge(left, right):
    merged = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            merged.append(left[i])
            i += 1
        else:
            merged.append(right[j])
            j += 1

    while i < len(left):
        merged.append(left[i])
        i += 1

    while j < len(right):
        merged.append(right[j])
        j += 1

    return merged


n = int(input())
arr = []
a_input = input().split()
for i in range(n):
    a = int(a_input[i])
    arr.append(a)
sorted_arr = merge_sort(arr)
print("Answer:", ' '.join(map(str, sorted_arr)))
