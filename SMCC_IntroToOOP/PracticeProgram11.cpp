#include <iostream>
using namespace std;
int main ( )
{
    int haveMoney = 0;
    int haveTime = 0;
    int amHungry = 0;
    int restaurantOpen = 0;
    int haveTransportation = 0;
    
    cout << "Answer the following questions with 1 for yes and 2 for no." << endl;
    cout << "Do you have money to pay for lunch? ";
    cin >> haveMoney;
    cout << "Do you have time for lunch? ";
    cin >> haveTime;
    cout << "Are you hungry? ";
    cin >> amHungry;
    cout << "Is the restaurant open? ";
    cin >> restaurantOpen;
    cout << "Do you have transportation? ";
    cin >> haveTransportation;
    
    if ((haveMoney = 2))
    {
        cout << "You will not go to lunch.";
    }
    
    else ((haveMoney = 1));
    {
        if ((haveTime = 2))
        {
            cout << "You will not go to luch.";
        }
        else ((haveTime = 1));
        {
            if ((amHungry = 2))
            {
                cout << "You will not go to lunch.";
            }
            else ((amHungry = 1));
            {
                if ((restaurantOpen = 2))
                {
                    cout << "You will not go to lunch.";
                }
                else ((restaurantOpen = 1));
                {
                    if ((haveTransportation = 2))
                    {
                        cout << "You will not go to lunch.";
                    }
                    else ((haveTransportation = 1));
                    {
                        cout << "You will get lunch.";
                    }
                }
            }
        }
    }

    
    cout << endl;
    return 0;
}