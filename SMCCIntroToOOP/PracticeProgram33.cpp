#include <iostream>
using namespace std;
#include <cmath>
#include <iomanip>
#include <math.h>
int conversion (int date)
{
    int m = date / 1000;
    int c = ((date % 1000) / 100);
    int l = ((date % 100) / 50);
    int x = ((date % 50) / 10);
    int i = ((date % 10) / 1);
    int z = i + x + l + c + m;
    
    while (z > 0)
    {
        if (m > 0)
        {
            cout << "M";
            m--;
            z--;
        }
        else if (c > 0)
        {
            cout << "C";
            c--;
            z--;
        }
        else if (l > 0)
        {
            cout << "L";
            l--;
            z--;
        }
        else if (x > 0)
        {
            cout << "X";
            x--;
            z--;
        }
        else if (i > 0)
        {
            cout << "I";
            i--;
            z--;
        }
    }
    cout << endl;
    return 0;
}

int main ()
{
    int date = 0;
    cout << "Enter a four digit year: ";
    cin >> date;
    cout << conversion (int (date));
    cout << endl;
    return 0;
}