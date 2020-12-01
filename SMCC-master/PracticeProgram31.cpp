#include <iostream>
using namespace std;
#include <cmath>
#include <iomanip>
int calcArea (int side)
{
    int area = side * side;
    return area;
}

int calcDiameter (int side)
{
    int diameter = side;
    return diameter;
}

int calcCircumference(int side)
{
    int circumference = side * 4;
    return circumference;
}

int main ()
{
    int side = 0;
    cout << "How long is one side of the square? ";
    cin >> side;
    cout << calcArea(int (side)) << ", " << calcDiameter(int (side)) << ", " << calcCircumference(int (side)) << endl;
}