#include <iostream>
using namespace std;
#include <cmath>
#include <iomanip>
int main () {
    int arrayIntegers[50] = {0}; //
    int i = 0; //creates the integer i to use in the for statement
    cout << fixed;                //writes values in fixed position notation
    cout << setprecision(0);      //sets the output to be integer values only
    cout << setw(50);             //adds spaces to the first line printed
    cout << right;                //changes default character setting to right side of the output
    for(i = 0; i < 50; i++) //creates a loop to repeat the following code for the whole array
    {
        cout << " ------------------------------------------- " << endl; //prints line of hyphens before each repetition
        cout << " 2 ^ " << i << " = " << pow(2.0,i) << endl;; //prints 2^i = 2^i value with spaces between everything
        arrayIntegers[i] = pow(2.0, i); //sets the power of 2 value to the array space
        cout << "2^" << i <<"="<< arrayIntegers[i]<<endl; //prints the same as the last cout line but without spaces
    }
    return 0;
}