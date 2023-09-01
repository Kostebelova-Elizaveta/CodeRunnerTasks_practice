#include <iostream>
#include <vector>
using namespace std;

int partition(vector<int>& arr, int low, int high)
{
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j <= high - 1; j++)
    {
        if (arr[j] > pivot)
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

    if (num == 1)
    {
        help[0] = 0;
    }
    else
    {
        for (int i = 0; i < num; i++)
        {
            if (i == 0)
            {
                help[i] = -arr[i + 1];
            }
            else
            {
                if (i == num - 1)
                {
                    help[i] = arr[i - 1];
                }
                else
                {
                    help[i] = arr[i - 1] - arr[i + 1];
                }
            }
        }
    }

    quickSort(help, 0, num - 1);

    for (int i = 0; i < num; i++)
    {
        if (i == num - 1)
            cout << help[i] << endl;
        else
            cout << help[i] << " ";
    }

    return 0;
}
