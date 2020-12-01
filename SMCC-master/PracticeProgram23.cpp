#include <iostream>
using namespace std;
int main ( )
{
    // Sample INFINITE LOOP
    // Condition is always true
    int i = 0;  // 1st element of loop - declare and set initial value
    while ( i <= 10 ) // 2nd element of loop - condition (switched 0 to 10) (could also change > to < or =)
    {  
        cout << "i = " << i << endl;
        i++; // 3rd element of loop - update value
    }
    return 0;
}