#include <iostream>
using namespace std;
int main ( )
{
    string firstName;
    int age = 0;
    
    cout << "What is your name? ";
    cin >> firstName;
    
    cout << "How old are you? ";
    cin >> age;
    
    if (age >= 18) { cout << "You are an adult."; }
    else { cout << "You are not an adult."; }

    cout << endl;
    return 0;
}