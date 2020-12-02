#include <iostream>
using namespace std;
#include <cmath>
#include <iomanip>
#include <math.h>

string getName ();
int getAge ();
void printFunction (string firstName, int age);

int main ()
{
    string name = getName();
    int old = getAge();
    printFunction(name, old);
}
void printFunction (string firstName, int age)
{
    cout << "First name: " << firstName << endl;
    cout << "Age: " << age << endl;
}

int getAge ()
{
    int age = 0;
    cout << "What is your age? ";
    cin >> age;
    return age;
}

string getName ()
{
    string firstName;
    cout << "What is your first name? ";
    cin >> firstName;
    return firstName;
}