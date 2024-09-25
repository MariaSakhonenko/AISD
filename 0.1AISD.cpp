#include <iostream>
#include <vector>

using namespace std;

// Функция для выполнения бинарного поиска
void binary_search(const vector<int>& arr, int x) 
{
    int n = arr.size();
    int left = 0, right = n;
    int b = 0; // Признак наличия элемента

    // Поиск первого элемента, большего или равного x
    while (left < right) 
    {
        int mid = left + (right - left) / 2;
        if (arr[mid] < x) 
        {
            left = mid + 1;
        }
        else
        {
            right = mid;
        }
    }
    int l = left; // Индекс первого элемента, большего или равного x

    // Проверяем, есть ли элемент x в массиве
    if (l < n && arr[l] == x) 
    {
        b = 1; // Элемент найден
    }

    // Поиск первого элемента, большего x
    left = 0;
    right = n;
    while (left < right) 
    {
        int mid = left + (right - left) / 2;
        if (arr[mid] <= x) 
        {
            left = mid + 1;
        }
        else
        {
            right = mid;
        }
    }
    int r = left; // Индекс первого элемента, большего x

    // Вывод результатов
    cout << b << " " << l << " " << r << endl;
}

int main() 
{
    int n;
    cin >> n;
    vector<int> arr(n);

    for (int i = 0; i < n; i++) 
    {
        cin >> arr[i];
    }

    int k;
    cin >> k;
    vector<int> queries(k);

    for (int i = 0; i < k; i++)
    {
        cin >> queries[i];
    }

    for (int i = 0; i < k; i++) 
    {
        binary_search(arr, queries[i]);
    }

    return 0;
}
