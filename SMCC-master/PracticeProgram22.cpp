#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    cout << setw (4);
    for (int x = 1; x <= 12 ; x++)
    {
        for (int y = 1; y <= 12; y++)
        {
            cout << x * y;
            cout << setw (4);
        }
        cout << endl;
    }
    cout << endl;
    return 0;
}