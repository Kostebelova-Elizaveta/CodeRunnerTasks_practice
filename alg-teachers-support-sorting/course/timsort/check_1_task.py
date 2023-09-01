import subprocess, sys

def generate():
    arr = [[-14, 77, 15, 93, 35, 86, -8, -51, -79, 62, -73, -10, -41, 63, 26, 40, -74, 72, 36, -89, 68, 67, -71, 82, 30, -38, 23, -33, 35, 29, -98, -78, -42, -31, 67, 93, -44, -89, -58, -71], 
    [4, 3, 5, 1, 2], 
    [-23], 
    [-20, 5, -40, 10, -9, -405, 609, -1, 1, 0], 
    [-2, -2, -2, -2, -2]]
    return arr

def check(reply, clue):
    return str(reply).strip() == str(clue).strip()

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

def timsort(arr):
    result = ""

    # Определяем размер блока для сортировки
    min_run = 32

    # Разделяем массив на блоки и сортируем их
    runs = split_into_runs(arr, min_run)
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

