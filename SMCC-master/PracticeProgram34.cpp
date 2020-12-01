#include <iostream>
using namespace std;
#include <cmath>
#include <iomanip>
#include <math.h>
int squareInteger (int x)
{
    int squaredI = pow (x, 2);
    return squaredI;
}

double squareDouble (double d)
{
    double squaredD = pow (d, 2);
    return squaredD;
}

float squareFloat (float f)
{
    float squaredF = pow (f, 2);
    return squaredF;
}

int main ()
{
    int x = 0;
    double d = 0;
    float f = 0;
    cout << "Enter an integer: ";
    cin >> x;
    cout << "Enter a double: ";
    cin >> d;
    cout << "Enter a float: ";
    cin >> f;
    cout << squareInteger(int (x)) << endl << squareDouble(double (d)) << endl << squareFloat(float (f));
    cout << endl;
    return 0;
}