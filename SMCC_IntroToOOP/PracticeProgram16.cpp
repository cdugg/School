#include <iostream>
using namespace std;
#include <string>
int main()
{
    int userCoice = 0;
    cout << "Please choose a number between 1 and 10. ";
    cin >> userCoice;
    if (userCoice > 10 || userCoice < 0)
    {
        cout << "Number choice unavailable.";
    }
    else
    {
        if (userCoice == 0)
        {
            cout << "Zero" << endl;
        }
        else if (userCoice == 1)
        {
            cout << "One" << endl;
        }
        else if (userCoice == 2)
        {
            cout << "Two" << endl;
        }
        else if (userCoice == 3)
        {
            cout << "Three" << endl;
        }
        else if (userCoice == 4)
        {
            cout << "Four" << endl;
        }
        else if (userCoice == 5)
        {
            cout << "Five" << endl;
        }
        else if (userCoice == 6)
        {
            cout << "Six" << endl;
        }
        else if (userCoice == 7)
        {
            cout << "Seven" << endl;
        }
        else if (userCoice == 8)
        {
            cout << "Eight" << endl;
        }
        else if (userCoice == 9)
        {
            cout << "Nine" << endl;
        }
        else if (userCoice == 10)
        {
            cout << "Ten" << endl;
        }
    }
    
    return 0;
}