#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    int numbers[16] = {0};
    for (int i = 1; i <= 17; i++)
    {
        cout << "Enter integer value: ";
        cin >> numbers[i-1];
    }
    for (int x = 1; x <= 17; x++)
    {
        cout << numbers[x-1] << endl;
    }
    
    cout << endl;
    return 0;
}