n = int(input())
vec = []
a_input = input().split()
for i in range(n):
    a = int(a_input[i])
    vec.append((a, 0))

if n != 1:
    for i in range(n):
        if i == 0:
            vec[i] = (vec[i][0], vec[i+1][0])
        elif i == n-1:
            vec[i] = (vec[i][0], vec[i-1][0])
        else:
            vec[i] = (vec[i][0], vec[i+1][0] * vec[i-1][0])

# Сортировка вставками
for i in range(1, n):
    j = i
    while j > 0 and vec[j-1][1] >= vec[j][1]:
        if vec[j-1][1] == vec[j][1]:
            if vec[j-1][0] > vec[j][0]:
                vec[j-1], vec[j] = vec[j], vec[j-1]
        else:
            vec[j-1], vec[j] = vec[j], vec[j-1]
        j -= 1
        print(' '.join(str(e[0]) for e in vec))

print("Answer:", ' '.join(str(e[0]) for e in vec))
