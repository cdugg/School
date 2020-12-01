#include <iostream> //iostream not oistream
using namespace std;//had second semicolon
#include <string>
int main() {
    string favoriteFirstName;
    int age = 0;
    char gender = 'x';
    cout << "Enter your favorite first name: ";  // cout allows you to write a message (type in name, not necessarily a fix but makes it look better)
    cin >> favoriteFirstName;                           // cin allows you to input a value
    cout << endl; //cout arrows facing wrong direction
    cout << "Enter you age: ";
    cin >> age;
    cout << endl;
    cout << "Enter you Gender F/M: ";
    cin >> gender; //gender variable should not be capitalized
    // Logical AND table --  ((exp1) && (exp2) && (exp3) )...
    if ( ( age > 20 ) && ( gender == 'F') && ( favoriteFirstName == "YourFavoriteNameHere"  )) //second and statement missing second & and missing closing parentheses favoriteFirstName variable misspelled
        {  // And coniditions: Takes ALL to be TRUE, so result is TRUE
            cout << endl << " ALL conditions ARE TRUE " << endl;     } //extra l at end of enl statement
        else     {
            // And conditions: Only takes one FALSE condition, so result is FALSE
            cout << " One or more conditions is FALSE " << endl;     } //cout arrows facing wrong direction
        //system("pause"); // pause statement Only for PC, not MAC  - Macs Comment out this line
        return 0;
}