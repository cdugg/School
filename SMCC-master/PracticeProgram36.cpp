#include <iostream>
using namespace std;

void myFunction (int x)
{
    for (int counter = x; counter > 0; counter--)
    {
        if(counter == 0)
        {
        }
        else
        {
            cout << counter << endl;
        }
    }
}

int main ()
{
    int x = 10;
    myFunction (x);
}