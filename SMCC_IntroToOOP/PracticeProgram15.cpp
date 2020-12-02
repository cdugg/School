#include <iostream>
using namespace std;
int main ( )
{
    int dayOfWeek = 0;
    int roomState = 0;
    int homeworkState = 0;
    
    cout << "Days of the week are numbered as follows; 1. Monday, 2. Tuesday, 3. Wednesday, 4. Thursday, 5. Friday, 6. Saturday, 7. Sunday." << endl;
    cout << "What number day of the week is today? ";
    cin >> dayOfWeek;
    
    cout << "Now use 1 to answer yes and 0 to answer no." <<endl;
    cout << "Is your room clean? ";
    cin  >>roomState;
    cout << "Is your homework finished? ";
    cin >> homeworkState;
    
    if ((dayOfWeek >= 1) && (dayOfWeek <=3))
    {
        if ((roomState == 1) && (homeworkState == 1))
            cout << "You can play.";
        else
            cout << "You may not play.";
    }
    else
    {
        if ((roomState == 1) || (homeworkState==1))
            cout << "You can play.";
        else
            cout << "You may not play.";
    }
    cout << endl;
}