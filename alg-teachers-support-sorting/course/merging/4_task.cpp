#include <iostream>
#include <math.h>
using namespace std;

// Функция для слияния двух подмассивов
void merge(std::pair<int, int> arr[], std::pair<int, int> left[], int leftSize, std::pair<int, int> right[], int rightSize) {
    int i = 0, j = 0, k = 0;

    // Слияние двух подмассивов в основной массив
    while (i < leftSize && j < rightSize) {
        if (left[i].second >= right[j].second) { //CHANGE HERE
            arr[k] = left[i];
            i++;
        }
        else {
            arr[k] = right[j];
            j++;
        }
        k++;
    }

    // Добавление оставшихся элементов из левого подмассива (если есть)
    while (i < leftSize) {
        arr[k] = left[i];
        i++;
        k++;
    }

    // Добавление оставшихся элементов из правого подмассива (если есть)
    while (j < rightSize) {
        arr[k] = right[j];
        j++;
        k++;
    }
}

// Функция для сортировки слиянием
void mergeSort(std::pair<int, int> arr[], int size) {
    if (size <= 1) {
        return;
    }

    double k = double(size)/double(2);
    int mid = ceil(k);
    std::pair<int, int> left[mid];
    std::pair<int, int> right[size - mid];

    // Заполнение левого подмассива
    for (int i = 0; i < mid; i++) {
        left[i] = arr[i];
    }

    // Заполнение правого подмассива
    for (int i = mid; i < size; i++) {
        right[i - mid] = arr[i];
    }

    // Вывод разделения на подмассивы
    cout << "Merging arr: ";
    for (int i = 0; i < mid; i++) {
        if (i == mid - 1) cout << left[i].first << " ";
        else cout << left[i].first << " ";
        
    }
    for (int i = 0; i < size - mid; i++) {
        if (i == size - mid - 1) cout << right[i].first << endl;
        else cout << right[i].first << " ";
        
    }

    // Рекурсивный вызов для сортировки левого подмассива
    mergeSort(left, mid);

    // Рекурсивный вызов для сортировки правого подмассива
    mergeSort(right, size - mid);

    // Слияние отсортированных подмассивов
    merge(arr, left, mid, right, size - mid);
}

int main() {
    int size;
    cin >> size;
    std::pair<int, int> arr[size];

    for (int i = 0; i < size; i++) {
        cin >> arr[i].first;
    }

    for (int i = 0; i < size; i++) {
        if (i == 0) {
            arr[i].second = arr[i+1].first;
        }
        else {
            if (i == size-1) {
                arr[i].second = arr[i-1].first;
            }
            else {
                if (arr[i+1].first > arr[i-1].first) {
                    arr[i].second = arr[i+1].first;
                } 
                else {
                    arr[i].second = arr[i-1].first;
                } 
            }
        } 
    }

    mergeSort(arr, size);

    cout << "Answer: ";
    for (int i = 0; i < size; i++) {
        if (i == size - 1) cout << arr[i].first <<  endl;
        else cout << arr[i].first << " ";
    }

    return 0;
}