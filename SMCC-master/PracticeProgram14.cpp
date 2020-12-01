#include <iostream>
using namespace std;
int main ( )
{
    int haveMoney = 0;
    int restaurantOpen = 0;
    int haveTime = 0;
    int haveTransportation = 0;
    int amHungry = 0;
    int willToGetUp = 0;
    
    cout << "Enter 1 for yes and 0 for no." << endl;
    cout << "Do you have money? ";
    cin >> haveMoney;
    cout << "Is the restaurant open? ";
    cin >> restaurantOpen;
    cout << "Do you have time? ";
    cin >> haveTime;
    cout << "Do you have transportation? ";
    cin >> haveTransportation;
    cout << "Are you hungry? ";
    cin >> amHungry;
    cout << "Do you have the will to get up and do something? ";
    cin >> willToGetUp;
    
    if ((haveMoney == 0) || (haveTransportation == 0) || (restaurantOpen == 0) || (haveTime == 0) || (amHungry == 0) || (willToGetUp == 0))
        cout << "You will not get lunch.";
    else
    {
        cout << "You will get lunch.";
    }
    
    cout << endl;
    return 0;
}