import math

def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = math.ceil(len(arr) / 2)
    left = arr[:mid]
    right = arr[mid:]

    print("Merging arr:", ' '.join(str(e[0]) for e in arr))

    left = merge_sort(left)
    right = merge_sort(right)

    return merge(left, right)


def merge(left, right):
    merged = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i][1] >= right[j][1]:
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
    arr.append([a, 0])  

for i in range(len(arr)):
    if i == 0:
        arr[i][1] = arr[i+1][0]
    elif i == n-1:
        arr[i][1] = arr[i-1][0]
    else:
        if arr[i+1][0] > arr[i-1][0]:
            arr[i][1] = arr[i+1][0]
        else:
            arr[i][1] = arr[i-1][0]


sorted_arr = merge_sort(arr)
print("Answer:", ' '.join(str(e[0]) for e in sorted_arr))