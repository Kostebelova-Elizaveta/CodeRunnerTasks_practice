n = int(input())
vec = []
a_input = input().split()
for i in range(n):
    a = int(a_input[i])
    vec.append(a)

# сортировка вставками
for i in range(1, n):
    j = i
    while j > 0 and vec[j-1] > vec[j]:
        vec[j-1], vec[j] = vec[j], vec[j-1]
        j -= 1
        print(' '.join(str(e) for e in vec))

print("Answer:", ' '.join(str(e) for e in vec))