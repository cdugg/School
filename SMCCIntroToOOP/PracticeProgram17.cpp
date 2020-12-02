#include <iostream>
using namespace std;
#include <string>
int main()
{
    int userCoice = 0;
    cout << "Please choose a game mode. " << endl << "1. Single Player" << endl << "2. Two player – You verse computer generated player" << endl << "3. Two player – You verse another person player" << endl << "4. Multiplayer – Internet connection – Real persons" << endl << "5. Exit" << endl;
    cin >> userCoice;
    
    switch (userCoice)
    {

        case 1:
            cout << "You choose Single Player." << endl;
            break;
        case 2:
            cout << "You choose Multiple Player - Computer." << endl;
            break;
        case 3:
            cout << "You choose Multiple Player - Player." << endl;
            break;
        case 4:
            cout << "You choose Multiple Player - Internet." << endl;
            break;
        case 5:
            cout << "You chose to exit." << endl;
            break;
        default:
            cout << "You chose an invalid choice." << endl;
    }
    return 0;
}