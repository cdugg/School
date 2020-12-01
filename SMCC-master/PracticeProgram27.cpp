#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    string names[5] = {""};
    for (int i = 1; i <= 6; i++)
    {
        cout << "Enter name: ";
        cin >> names[i-1];
    }
    for (int x = 1; x <= 6; x++)
    {
        cout << names[x-1] << endl;
    }
    
    cout << endl;
    return 0;
}