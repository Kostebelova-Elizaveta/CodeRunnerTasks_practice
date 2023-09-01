#include <iostream>
#include <vector>

int main() {
    int n;
    std::cin >> n;
    int a;
    std::vector<std::pair<int, int>> vec;
    for (int i=0; i<n; i++) {
        std::cin >> a;
        vec.push_back(std::make_pair(a, 0));
    }
    for (int i=0; i<n; i++) {
        if (i==0) {
            vec[i].second = vec[i+1].first;
        }
        else {
            if (i==n-1) {
                vec[i].second = vec[i-1].first;
            }
            else {
                vec[i].second = vec[i+1].first * vec[i-1].first;
            }
        }
    }
    // сортировка вставками
    for(int i=1;i<n;i++)     
	   for(int j=i;j>0 && vec[j-1].second>=vec[j].second; j--) { // пока j>0 и элемент j-1 > j, x-массив int
           if (vec[j-1].second==vec[j].second) {
               if (vec[j-1].first>vec[j].first) {
                   std::swap(vec[j-1],vec[j]);
               }
           }
           else {
               std::swap(vec[j-1],vec[j]);        // меняем местами элементы j и j-1
           }
			
           for (int i=0; i<n; i++) {
               if (i == n-1) {
                   std::cout << vec[i].first << std::endl;
               }
               else {
                   std::cout << vec[i].first << " ";
               }
            }
       }
    
    std::cout << "Answer: ";
    for (int i=0; i<n; i++) {
        if (i == n-1) {
                   std::cout << vec[i].first << std::endl;
               }
               else {
                   std::cout << vec[i].first << " ";
               }
    }
}