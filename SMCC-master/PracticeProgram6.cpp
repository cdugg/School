#include <iostream>
using namespace std;
int main ( )
{
double a = 16;
double b = 6;
double c = 3;


cout << a + b / c << endl;
    
cout << (a + b) / c << endl;
    
cout << a + (b / c) << endl;
    
cout << "The results of the first and third case are the same due to order of operations. Parentheses are the first operation done followed by division and lastly addition." << endl;
}