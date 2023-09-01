import subprocess, sys

def generate():
    input_list = [[4, 22, 1, 4, 22, 4, 22, 1, 10], [1], [-4, -4, -4, -4], [-5, 6, 6, -5], [58, -23, 45, 1, 0, -20, 4009, -1024, -8]]
    return input_list

def check(reply, clue):
    return str(reply).strip() == str(clue).strip()

def solve(arr):
    m = "{{QUESTION.parameters.m}}"
    frequencies = {}
    result = ""
    for num in arr:
        frequencies[num] = frequencies.get(num, 0) + 1
    
    # Сортируем массив по количеству повторений и, в случае равенства, по возрастанию
    if m == "убыванию":
        sorted_arr = sorted(arr, key=lambda x: (-frequencies[x], x))[::-1]
    else:
        sorted_arr = sorted(arr, key=lambda x: (-frequencies[x], -x))[::-1]
        
    for i in range(len(arr)):
        if i!=0:
            if not sorted_arr[i]==sorted_arr[i-1]:
                result = result + str(sorted_arr[i]) + " " + str(frequencies[sorted_arr[i]]) + "\n"
        else:
            result = result + str(sorted_arr[i]) + " " + str(frequencies[sorted_arr[i]]) + "\n"
    result = result + "Answer: " + ' '.join(map(str, sorted_arr)) + "\n"
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

