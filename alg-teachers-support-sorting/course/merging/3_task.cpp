#include <iostream>
#include <math.h>
using namespace std;

// Функция для слияния двух подмассивов
void merge(int arr[], int left[], int leftSize, int right[], int rightSize) {
    int i = 0, j = 0, k = 0;

    // Слияние двух подмассивов в основной массив
    while (i < leftSize && j < rightSize) {
        if (left[i] <= right[j]) {
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
void mergeSort(int arr[], int size) {
    if (size <= 1) {
        return;
    }

    double k = double(size)/double(2);
    int mid = ceil(k);
    int left[mid];
    int right[size - mid];

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
        if (i == mid - 1) cout << left[i] << " ";
        else cout << left[i] << " ";
        
    }
    for (int i = 0; i < size - mid; i++) {
        if (i == size - mid - 1) cout << right[i] << endl;
        else cout << right[i] << " ";
        
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
    int arr[size];

    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }

    mergeSort(arr, size);

    cout << "Answer: ";
    for (int i = 0; i < size; i++) {
        if (i == size - 1) cout << arr[i] << endl;
        else cout << arr[i] << " ";
    }

    return 0;
}