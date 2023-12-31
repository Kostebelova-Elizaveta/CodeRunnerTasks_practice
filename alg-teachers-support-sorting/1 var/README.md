# Теоретический вопрос
Соотнесите тип сортировки с её скоростью.


_Ответ 1:_
O(n^2)
Сортировка вставками

_Ответ 2:_
O(n log n)
Быстрая сортировка (qsort)

_Ответ 3:_
O(n log n)
Сортировка слиянием

_Ответ 4:_
O(n^2)
Сортировка подсчётом

_Ответ 5:_
O(n log n)
Timsort

# Задача №1

Имеется массив данных для сортировки int arr[] размера n

Необходимо сформировать новый массив, состоящий из сумм элементов, соседних с i-ым элементом массив arr, а затем произвести его сортировку методом быстрой сортировки (qsort) по возрастанию/убыванию.

### Примечание:

Если массив состоит только из 1 элемента => у него нет соседних, это нужно учитывать.

Для первого и последнего элемента считаем суммой соседних элементов просто значение следующего и предыдущего элемента соответственно. 
Т. е. при входных данных [1 2 3 4 5] для 0-го элемента 1 суммой будет 2 (следующий элемент), а для 4-го элемента 5 суммой будет просто 4 (предыдущий элемент).

Нельзя пользоваться готовыми библиотечными функциями для сортировки, нужно сделать реализацию сортировки вручную.



## Формат входа. 

Первая строка содержит натуральное число n - размерность массива, следующая строка содержит элементы массива через пробел.

## Формат выхода.

Одна строка, содержащая отсортированный массив сумм соседних элементов.


## (Внимание!) Пример для сортировки по убыванию.

### Вход:

10

-9 5 6 8 4 7 12 34 1 -2

### Выход:

41 32 16 15 13 13 10 5 1 -3


# Задача №2

Имеется массив данных для сортировки int arr[] размера n

Необходимо отсортировать его методом сортировки вставками по следующему критерию: наибольшее/наименьшее произведение соседних элементов массив (в случае равенства произведения соседних элементов - сортировка происходит по возрастанию).

Обязательное условие - выводить каждый шаг сортировки вставками


### Примечание:

Нельзя пользоваться готовыми библиотечными функциями для сортировки, нужно сделать реализацию сортировки вручную.

Если у массив состоит только из 1 элемента => у него нет соседних, это нужно учитывать.

Для первого и последнего элемента считаем произведением соседних элементов просто значение следующего и предыдущего элемента соответственно.

## Формат входа. 

Первая строка содержит натуральное число n - размерность массива, следующая строка содержит элементы массива через пробел.

## Формат выхода.

На каждом шагу сортировки выводится "промежуточный" массив. Последняя строчка должна содержать полностью отсортированный массив с пометкой "Answer:"


## (Внимание!) Пример для сортировки по наименьшему произведению соседних элементов массива.

### Вход:

4

-9 5 -6 8 

### Выход:

-9 -6 5 8 

-9 -6 8 5 

-9 8 -6 5 

8 -9 -6 5 

Answer: 8 -9 -6 5

### Пояснение примера:

В примере у нас дан массив [-9 5 -6 8], назовём его input.
Сортировка происходит по произведению соседних элементов, поэтому можно сформировать следующий массив, назовём его mult_input:

Для 0 элемента -9: 5

Для 1 элемента 5: -9 * -6 == 54

Для 2 элемента -6: 5 * 8 == 40

Для 3 элемента 8: -6

Следовательно полученный массив будет таким: [5 -54 40 8], его и необходимо отсортировать, получаем: [-6 5 40 54]

Однако необходимо выводить пошагово не сортировку вставками массива mult_input, а именно сортировку вставками массива input, опираясь на значения массива mult_input. 

Именно поэтому результатом сортировки будет являться отсортированный массив input, а именно [8 -9 -6 5]. 

Пошаговый вывод сортировки вставками точно также должен содержать шаги сортировки массива input.