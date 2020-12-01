#include <iostream>
using namespace std;
#include <cmath>
#include <iomanip>
int main () {
    int multiplicationTable[10][10] = {0};
    for (int i = 1; i <= 11; i++)
    {
        for (int x = 1; x <= 11; x++)
        {
            multiplicationTable[i][x] = i * x;
        }
    }
    cout << setw(5);
    for (int q = 1; q <= 11 ; q++)
    {
        for (int y = 1; y <= 11; y++)
        {
            cout << multiplicationTable[q][y];
            cout << setw (5);
        }
        cout << endl;
    }


    return 0;
}