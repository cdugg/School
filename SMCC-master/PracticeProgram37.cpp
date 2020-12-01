#include <iostream>
using namespace std;

int main ()
{
    int factorial = 1;
    int x = 7;
    for (int counter = 1; counter <= x; counter ++)
    {
        factorial = factorial * counter;
    }
    cout << factorial << endl;
    return 0;
}