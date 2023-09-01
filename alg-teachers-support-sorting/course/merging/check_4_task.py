import subprocess, sys, math

def generate():
    arr = [[[7,0], [4,0], [2,0], [6,0], [-10,0], [3,0], [5,0]], 
    [[1,0], [2,0]], 
    [[7,0], [4,0], [-10,0], [6,0], [2,0], [3,0], [5,0]], 
    [[-2, 0], [-2, 0], [-2, 0], [-2, 0], [-2, 0]], 
    [[-10, 0], [14,0], [25,0], [46,0], [-2,0], [91,0], [24,0]]]
    return arr

def check(reply, clue):
    return str(reply).strip() == str(clue).strip()

def merge_sort(arr, res):
    if len(arr) <= 1:
        return arr, res
    
    mid = math.ceil(len(arr) / 2)
    left = arr[:mid]
    right = arr[mid:]

    res = res + "Merging arr: " + ' '.join(str(e[0]) for e in arr) + "\n"
    
    left, res = merge_sort(left, res)
    right, res = merge_sort(right, res)
    
    return merge(left, right), res

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

def solve(arr):
    for i in range(len(arr)):
        if i == 0:
            arr[i][1] = arr[i+1][0]
        elif i == len(arr)-1:
            arr[i][1] = arr[i-1][0]
        else:
            if arr[i+1][0] > arr[i-1][0]:
                arr[i][1] = arr[i+1][0]
            else:
                arr[i][1] = arr[i-1][0]
    res = ""
    sorted_arr, res = merge_sort(arr, res)
    res = res + "Answer: " + ' '.join(str(e[0]) for e in sorted_arr) + "\n"
    return res

    

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
        output = subprocess.check_output(progr, input=str(len(test)) + "\n" + ' '.join(str(e[0]) for e in test), universal_newlines=True)
        correct_output = solve(test)
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

