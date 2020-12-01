#include <iostream>
using namespace std;
#include <cmath>
#include <iomanip>
#include <math.h>
double calcArea (double radius)
{
    double area = pow (M_PI * radius, 2);
    return area;
}

double calcDiameter (double radius)
{
    double diameter = radius * 2;
    return diameter;
}

double calcCircumference(double radius)
{
    double circumference = 2 * M_PI * radius;
    return circumference;
}

int main ()
{
    double radius = 0;
    cout << "How long is the radius? ";
    cin >> radius;
    cout << calcArea(double (radius)) << ", " << calcDiameter(double (radius)) << ", " << calcCircumference(double (radius)) << endl;
}