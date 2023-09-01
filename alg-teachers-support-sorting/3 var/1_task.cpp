#include <iostream>
#include <vector>

int main() {
    int n;
    std::cin >> n;
    int a;
    std::vector<int> vec;
    for (int i=0; i<n; i++) {
        std::cin >> a;
        vec.push_back(a);
    }
    // сортировка вставками
    for(int i=1;i<n;i++)     
	   for(int j=i;j>0 && vec[j-1]>vec[j]; j--) { // пока j>0 и элемент j-1 > j, x-массив int
			std::swap(vec[j-1],vec[j]);        // меняем местами элементы j и j-1
           for (int i=0; i<n; i++) {
            if (i == n-1) std::cout << vec[i] << std::endl;
            else std::cout << vec[i] << " ";
            }
       }
    
    std::cout << "Answer: ";
    for (int i=0; i<n; i++) {
        if (i == n-1) std::cout << vec[i] << std::endl;
        else std::cout << vec[i] << " ";
    }
}