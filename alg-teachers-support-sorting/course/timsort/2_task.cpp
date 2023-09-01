#include <iostream>
#include <vector>

const int MIN_RUN = 32;

bool compareSquares(int a, int b) {
    int squareA = a * a;
    int squareB = b * b;
    if (squareA == squareB) {
        return a < b;
    } else {
        return squareA > squareB;
    }
}

void printArray(std::vector<int>& arr) {
    for (int i = 0; i < arr.size(); i++) {
        if (i == arr.size()-1) std::cout << arr[i] << std::endl;
        else std::cout << arr[i] << " ";
    }
}

void insertionSort(std::vector<int>& arr, int left, int right) {
    for (int i = left + 1; i <= right; ++i) {
        int key = arr[i];
        int j = i - 1;
        while (j >= left && compareSquares(arr[j], key)) {
            arr[j + 1] = arr[j];
            --j;
        }
        arr[j + 1] = key;
    }
}

void merge(std::vector<int>& arr, int left, int mid, int right) {
    int len1 = mid - left + 1;
    int len2 = right - mid;

    std::vector<int> leftArr(len1);
    std::vector<int> rightArr(len2);

    for (int i = 0; i < len1; ++i) {
        leftArr[i] = arr[left + i];
    }
    for (int i = 0; i < len2; ++i) {
        rightArr[i] = arr[mid + 1 + i];
    }

    int i = 0, j = 0, k = left;
    while (i < len1 && j < len2) {
        if (leftArr[i]*leftArr[i] < rightArr[j]*rightArr[j]) {  // Исправленное условие
            arr[k] = leftArr[i];
            ++i;
        } else {
            if (leftArr[i] > rightArr[j]) {
            arr[k] = leftArr[i];
            ++i;
        } else {
            arr[k] = rightArr[j];
            ++j;
            }
        }
        ++k;
    }

    while (i < len1) {
        arr[k] = leftArr[i];
        ++i;
        ++k;
    }

    while (j < len2) {
        arr[k] = rightArr[j];
        ++j;
        ++k;
    }

      std::cout << "Part 0: ";
      for (int i = 0; i < len1; ++i) {
          if (i == len1 - 1) std::cout << leftArr[i] << std::endl;
          else std::cout << leftArr[i] << " ";
      }
    
      std::cout << "Part 1: ";
      for (int i = 0; i < len2; ++i) {
        if (i == len2 - 1) std::cout << rightArr[i] << std::endl;
          else std::cout << rightArr[i] << " ";
      }
}

void timsort(std::vector<int>& arr) {
    bool check = true;
    int n = arr.size();

    for (int i = 0; i < n; i += MIN_RUN) {
        insertionSort(arr, i, std::min(i + MIN_RUN - 1, n - 1));
    }

    for (int size = MIN_RUN; size < n; size *= 2) {
        for (int left = 0; left < n; left += 2 * size) {
            int mid = left + size - 1;
            int right = std::min(left + 2 * size - 1, n - 1);
            merge(arr, left, mid, right);
            check = false;
        }
    }

    if (check) {
        std::cout << "Part 0: ";
        for (int i = 0; i < n; ++i) {
            if (i == n-1) std::cout << arr[i] << std::endl;
            else std::cout << arr[i] << " ";
        }
      }
}

int main() {
    int n;
    std::cin >> n;

    int a;
    std::vector<int> arr;
    for (int i = 0; i < n; i++) {
        std::cin >> a;
        arr.push_back(a);
    }

    timsort(arr);

    std::cout << "Answer: ";
    printArray(arr);

    return 0;
}