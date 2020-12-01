
#include <iostream> 
using namespace std;
int main ( )
{
int height = 0;
int feet = 0;
int inches = 0;


cout << "How tall are you in feet only: ";
cin >> feet;
cout << "You are " << feet << " and how many inches tall: ";
cin >> inches;

height = inches + feet * 12;

cout << "You are " << height << " inches tall" << endl ;
}