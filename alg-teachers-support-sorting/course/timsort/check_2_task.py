import subprocess, sys

def generate():
    arr = [[-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6], 
    [5, -1, 6, -6, 0, -4, 7, -2, -2, 9, -2, -10, 5, 8, 3, 2, 2, 8, 9], 
    [-43], 
    [10, -10, 10], 
    [5, 4, -5, -4, -6, -6, -6, 6, 4, 5]]
    return arr

def check(reply, clue):
    return str(reply).strip() == str(clue).strip()
   
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
    
def timsort(arr):

    # Определяем размер блока для сортировки
    min_run = 32

    # Разделяем массив на блоки и сортируем их
    runs = split_into_runs(arr, min_run)
    result = ''
    for i in range(len(runs)):
        result = result + "Part " + str(i)+': ' + ' '.join(str(e) for e in runs[i]) + "\n"

    # Слияние отсортированных блоков
    sorted_arr = merge_runs(runs)
    result = result + "Answer: " + ' '.join(str(e) for e in sorted_arr) + "\n"
    return result


    

lines = """{{ STUDENT_ANSWER | e('py') }}"""
language = """{{ ANSWER_LANGUAGE | e('py') }}""".lower()
language_extension_map = {'cpp':'cpp', 'python3':'py'}

if language not in language_extension_map.keys():
    raise Exception('Error in question. Unknown/unexpected language ({})'.format(language))

if language == 'python3':
    if (lines.find("np.sort") == -1) and (lines.find("sorted(") == -1):
        with open("prog.py", "w") as src:
            print(lines, file=src)
        progr = ["python3", "prog.py"]
    else:
        print('You can not use ready-made algorithms!')
        exit(-1)
elif language == 'cpp':
    if (lines.find("qsort") == -1) and (lines.find("std::sort") == -1):
        with open("prog.cpp", "w") as src:
            print(lines.replace(language, ''), file=src)
        return_code = subprocess.check_call("g++ -std=c++11 prog.cpp -o prog".split())
        if return_code != 0:
            print("** Compilation failed. Testing aborted **", file=sys.stderr)
            exit(-1)
        progr = ["./prog"]
    else:
        print('You can not use ready-made algorithms!')
        exit(-1)
else:
    print('Unknown language')
    exit(-1)


tests = generate()
incorrect_count = 0
correct_count = 0
COUNT_OPEN_TESTS = 5

try:
    for test in tests:
        output = subprocess.check_output(progr, input=str(len(test)) + "\n" + ' '.join(str(e) for e in test), universal_newlines=True)
        correct_output = timsort(test)
        if not check(output, correct_output):
            incorrect_count += 1
            if incorrect_count < COUNT_OPEN_TESTS:
                result = 'Test: {}\n'.format(test)
                result += 'Your answer: {}\n'.format(output)
                result += 'Correct: {}\n'.format(correct_output)
                print(result)
        else:
            correct_count += 1
except subprocess.CalledProcessError as e:
    if e.returncode > 0:
        # Ignore non-zero positive return codes
        if e.output:
            print(e.output)
    else:
        # But negative return codes are signals - abort
        if e.output:
            print(e.output, file=sys.stderr)
        if e.returncode < 0:
            print("Task failed with signal", -e.returncode, file=sys.stderr)
        print("** Further testing aborted **", file=sys.stderr)
if correct_count == len(tests):
    print('OK')
else:
    print('Wrong answer')

