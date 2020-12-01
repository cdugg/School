#include <iostream>

using namespace std;
int main(){
    int height = 0, feet = 0, inches = 0;
    cout <<"What is your height in inches (example 66): " <<endl;
    cin >> height;
    feet = height / 12;
    inches = height % 12;
    cout << "My Height is " << feet << " feet and " << inches << " Inches " << endl;
    
    return 0;
}