import subprocess, sys

def generate():
    vec = [[2, 3, -5, 6, 7], [1], [5, 5, 5, 5, 5], [-15, 22, 33, 46, 57], [-59, 78, 102, 291, 357, 444, 666]]
    return vec

def check(reply, clue):
    return str(reply).strip() == str(clue).strip()

def solve(vec):
    m = "{{QUESTION.parameters.m}}"
    result = ""
    
    # Сортировка вставками
    if m == "возрастанию":
        for i in range(1, len(vec)):
            j = i
            while j > 0 and vec[j-1] > vec[j]:
                vec[j-1], vec[j] = vec[j], vec[j-1]
                j -= 1
                result = result + ' '.join(str(e) for e in vec) + "\n"
    else:
        for i in range(1, len(vec)):
            j = i
            while j > 0 and vec[j-1] < vec[j]:
                vec[j-1], vec[j] = vec[j], vec[j-1]
                j -= 1
                result = result + ' '.join(str(e) for e in vec) + "\n"
                
    result = result + "Answer: " + ' '.join(str(e) for e in vec) + "\n"
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

