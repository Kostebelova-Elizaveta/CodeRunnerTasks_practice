#include <iostream>
#include <vector>
#include <unordered_map>

bool compare(const std::pair<int, int>& a, const std::pair<int, int>& b) {
    if (a.second != b.second) {
        return a.second < b.second; // Сортировка по убыванию количества повторений
    }
    return a.first > b.first; // Сортировка по возрастанию элементов в случае равенства количества повторений
}

void sortByFrequency(int arr[], int n) {
    std::unordered_map<int, int> frequencyMap;
    for (int i = 0; i < n; i++) {
        frequencyMap[arr[i]]++;
    }

    
    std::vector<std::pair<int, int>> frequencyPairs;
    for (const auto& pair : frequencyMap) {
        frequencyPairs.push_back(pair);
    }

    for(int i=1;i<frequencyPairs.size();i++)     
	   for(int j=i;j>0 && compare(frequencyPairs[j-1],frequencyPairs[j]); j--) {
			std::swap(frequencyPairs[j-1],frequencyPairs[j]);
       }

    for (const auto& pair : frequencyPairs) {
        std::cout << pair.first << " " << pair.second << std::endl;
    }

    int index = 0;
    for (const auto& pair : frequencyPairs) {
        int num = pair.first;
        int count = pair.second;
        for (int i = 0; i < count; i++) {
            arr[index++] = num;
        }
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        if (i == n-1) std::cout << arr[i] << std::endl;
        else std::cout << arr[i] << " ";
    }
}

int main() {
    int n;
    std::cin >> n;
    int arr[n];
    for (int i = 0; i<n; i++) {
        std::cin >> arr[i];
    }


    sortByFrequency(arr, n);

    std::cout << "Answer: ";
    printArray(arr, n);

    return 0;
}