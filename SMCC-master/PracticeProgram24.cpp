#include <stdio.h>
#include <iostream>
using namespace std;
int main(void)
{
    int numberOfRepetitions = 0;
    int q = 1;
    cout << "How many times numbers would you like to investigate? ";
    cin >> numberOfRepetitions;
    
    while (q <= numberOfRepetitions)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        double n = 0;
    
        cout << "Enter a number: ";
        cin >> n ;
        cout << "The prime numbers from 2 to " << n << " are " << endl;
    
        for(i = 2; i <= n; i++)
        {
            k = 0;
            for (j = 1; j <= i; j++)
                if (i%j == 0) k++;
            if (k == 2)
                cout << ", " <<i;
        }
        cout << endl;
        q++;
    }
    return 0;
}