#include <iostream>
using namespace std;
int main ( )
{
    int testScore = 0;
    
    cout << "Enter your numeric test grade: ";
    cin >> testScore;
    
    if (testScore < 60)
    {
        cout << "Your letter grade is an F.";
    }
    else
    {
        if (testScore < 70)
        {
            cout << "Your letter grade is a D.";
        }
        else
        {
            if (testScore < 80)
            {
                cout << "Your letter grade is a C.";
            }
            else
            {
                if (testScore < 90)
                {
                    cout << "Your letter grade is a B.";
                }
                else
                {
                    if (testScore <=100)
                    {
                        cout << "Your letter grade is an A.";
                    }
                }
            }
        }
    }
    
    
    cout << endl;
    return 0;
}