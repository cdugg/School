#include <iostream>
using namespace std;

int main ()
{
    int start = 1;
    int summation = 10;
    int sum = 0;
    
    for (int i = start; i <= summation; i ++)
    {
        sum = sum + i;
    }
    cout << sum << endl;
}