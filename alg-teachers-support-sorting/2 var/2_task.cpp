#include <iostream>
#include <vector>
#include <map>
using namespace std;
 
void countSort(vector<int> &input)
{
    // создаем пустую карту для хранения частот элементов массива
    map<int, int> freq;
 
    // сохраняем различные значения во входном массиве как ключ и
    // их соответствующие счетчики как значения
    for (int x: input) {
        freq[x]++;
    }
    for (auto &p: freq) {
        cout << p.first << " " << p.second << endl;
    }
 
    // обход карты и перезапись входного массива отсортированными элементами
    // (карта будет повторяться на основе отсортированного порядка ключей)
    int i = 0;
    for (auto &p: freq)
    {
        while (p.second--) {
            input[i++] = p.first;
        }
    }
}
 
int main()
{
    int n;
    int a;
    cin >> n;
    vector<int> input;
    for (int i=0; i<n; i++) {
        cin >> a;
        input.push_back(a);
    }
 
    countSort(input);

    cout << "Answer: ";
    for (int i=0; i<n; i++) {
        if (i == n-1) cout << input[i] << endl;
        else cout << input[i] << " ";
    }
 
    return 0;
}