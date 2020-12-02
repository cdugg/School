#include <iostream>
using namespace std;
int main ( )
{
    int choice = 0;
    double tempIn = 0;
    int tempOut = 0;
    
    cout << "Enter 1 for Celsius to Fahrenheit or 2 for Fahrenheit to Celsius: ";
    cin >> choice;
    cout << "What is the current temperature? ";
    cin >> tempIn;
    
    if ((choice = 1))
    {
        tempOut = tempIn * 1.8 + 32;
        cout << "The temperature in Celsius is " << tempIn << "º and the temperature in Fahrenheight is " << tempOut << "º";
    }
    else if ((choice = 2))
    {
        tempOut = (tempIn - 32) / 1.8;
        cout << "The temperature in Fahrenheit is " << tempIn << "º and the temperature in Celsius is " << tempOut << "º";
    }
    else
    {
        cout << "Error: please choose only either 1 or 2 for initial question.";
    }
    
    cout << endl;
    return 0;
}