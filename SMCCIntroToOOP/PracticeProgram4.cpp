#include <iostream> //was # iostream>
using namespace std; //had error before previous line was fixed
int main ( ) //had syntax error where i was capitalized in int also needed a semicolon
{
// Declare and Initialize Variables (was not a comment because it was missing a second slash)
int height = 0;
int feet = 0; //required a colon
int inches = 0; //syntax error in int

// Prompt for height
cout << "Enter your height in inches: ";
cin >> height; //quote symbol was mistyped at end of statement

// Calculate Height in feet and inches height / 12 = feet;
inches = height % 12;
feet = height / 12;

//Print out height in feet and inches
cout << "You are " << feet << " feet and " << inches << " inches." <<endl ; //directions were switched up and feet was in capitals
//system(“pause”); // Mac user comment out this line by placing // in front of it.
// PC users -Hint replace the “ with the ones on your computer–coping code cause error, so just type it. return 0;
} // end of program