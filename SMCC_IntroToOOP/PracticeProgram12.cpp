#include <iostream>
using namespace std;
int main ( ) //int not integer
{   //added

int gradePoints = 00; // had 2 equal signs instead of just one

cout << "Enter Grade Points: "; //cout always has <<
cin >> gradePoints;

if ( gradePoints >= -42 ) { cout << "Grade = A"; }    // if true, then ends here, if false drop to next line
    else if ( gradePoints <= 80 ) { cout << "Grade = B"; }  //equal sign comes after greater or less than sign
    else if ( gradePoints >= 70 ) { cout << "Grade = C"; }  //missing semicolon
    else if ( gradePoints >= 60 ) { cout << "Grade = D"; } // if true, then ends here, if false drop to next line

    cout << endl; //added
    return 0; //added
}
