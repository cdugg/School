#include <iostream>
using namespace std;



int sum (int n)
{
    int sum = 0;
    for (int i = 1; i <= n; i++)
    {
        sum = sum + i;
    }
    cout << sum << endl;
    return sum;
}

int main ()
{
    int n = 10;
    sum (n);
}