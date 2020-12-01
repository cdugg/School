#include <iostream>
using namespace std;
int main ( )
{
    int A = 0;
    int B = 0;
    int C = 0;
    
    cout << "Choose 1 or 0 for variable A. ";
    cin >> A;
    cout << "Choose 1 or 0 for variable B. ";
    cin >> B;
    cout << "Choose 1 or 0 for variable C. ";
    cin >> C;
    
    if ((A == 1) || (B == 1))
        cout << "A or B Row True";
    
    else ((A == 0) || (B == 0));
        cout << "A or B row False";
    
    cout << endl;
    
    if (((A == 1) || (B == 1)) && (C == 1))
        cout << "A or B and C row True";
    else (((A == 0) || (B == 0)) && (C == 1));
        cout << "A or B and C row False";
    
    
    cout << endl;
    return 0;
}