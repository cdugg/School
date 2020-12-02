#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    int i = 0;
    for (; ;)
    {
        i++;
        if (i <= 10)
            cout << "Loop " << i << endl;
    }
    return 0;
}