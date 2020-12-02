#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    for (int x = 1; x <= 6; x++)
    {
        cout << setw (6 * x);
        cout << "* Ώ" << endl;
        cout << setw (6 * x);
        cout << "*/|\\" << endl;
        cout << setw (6 * x);
        cout << "* /\\" << endl;
        cout << setw (6 * x);
        cout << "******" << endl;
    }
    return 0;
}