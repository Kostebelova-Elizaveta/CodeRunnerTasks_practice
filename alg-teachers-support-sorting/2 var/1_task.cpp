#include <iostream>
#include <vector>
using namespace std;

int partition(vector<int>& arr, int low, int high)
{
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j <= high - 1; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(arr[i], arr[j]);
        }
    }

    swap(arr[i + 1], arr[high]);
    return (i + 1);
}

void quickSort(vector<int>& arr, int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main()
{
    int num;
    cin >> num;

    vector<int> arr(num);
    vector<int> help(num);

    for (int i = 0; i < num; i++)
        cin >> arr[i];

    int size_of_arr_help = 0;
    

    for (int i=0; i<num; i++) {
        if (arr[i] % 2 == 0) {
            help[size_of_arr_help] = arr[i];
            size_of_arr_help++;
        }
    }
    
    if (size_of_arr_help == 0) {
        cout << endl;
        return 0;
    }
    

    quickSort(help, 0, size_of_arr_help - 1);

    for (int i = 0; i < size_of_arr_help; i++)
    {
        if (i == size_of_arr_help - 1)
            cout << help[i] << endl;
        else
            cout << help[i] << " ";
    }

    return 0;
}