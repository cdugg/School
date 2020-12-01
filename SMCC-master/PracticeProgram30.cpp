#include <iostream>
using namespace std;
#include <cmath>
#include <iomanip>
int main ()
{
    string forwardName[10] = {"Fred", "Tuyet", "Annie", "Moe", "Ria", "Luke", "Jim", "May", "Rex", "Omar"};
    string backwardName[10];
    
    for (int x = 0; x <= 9; x++)
    {
        backwardName[x] = forwardName[x];
    }
    for (int y = 0; y <= 9; y++)
    {
        backwardName[y] = backwardName[9-y];
    }
    
    for (int j = 0; j <= 9; j++)
    {
        cout << forwardName[j] << ", ";
    }
    cout << endl;
    for (int q = 0; q <= 9; q++)
    {
        cout << backwardName[q] << ", ";
    }
    
    cout << endl;
    return 0;
}
