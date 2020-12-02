#include <iostream>
using namespace std;

char choice[10] = {'o','1','2','3','4','5','6','7','8','9'};

int checkIfWin();
void createBoard();

int main ()
{
    int player = 1, x, squareNumber;
    char squareChoice;
    
    do
    {
        createBoard ();
        if (player == 1)
        {
            squareChoice = 'X';
        }
        else
        {
            squareChoice = 'O';
        }
        
        cout << "Please choose a sqare number player " << player << ": ";
        cin >> squareNumber;
        if (squareNumber == 1 && choice[1] == '1')
        {
            choice[1] = squareChoice;
        }
        else if (squareNumber == 2 && choice[2] == '2')
        {
            choice[2] = squareChoice;
        }
        else if (squareNumber == 3 && choice[3] == '3')
        {
            choice[3] = squareChoice;
        }
        else if (squareNumber == 4 && choice[4] == '4')
        {
            choice[4] = squareChoice;
        }
        else if (squareNumber == 5 && choice[5] == '5')
        {
            choice[5] = squareChoice;
        }
        else if (squareNumber == 6 && choice[6] == '6')
        {
            choice[6] = squareChoice;
        }
        else if (squareNumber == 7 && choice[7] == '7')
        {
            choice[7] = squareChoice;
        }
        else if (squareNumber == 8 && choice[8] == '8')
        {
            choice[8] = squareChoice;
        }
        else if (squareNumber == 9 && choice[9] == '9')
        {
            choice[9] = squareChoice;
        }
        else
        {
            cout << "Invalid move choice.";
            cin.ignore();
            cin.get();
        }
        
        x = checkIfWin();
        
        if (player == 1)
        {
            player++;
        }
        else
        {
            player--;
        }
    }while (x == 1);
    createBoard();
    
    if (x == 2)
    {
        cout << "Player " << --player << " wins!" << endl;
    }
    else
    {
        cout << "Cat's game.";
    }
    return 0;
}

int checkIfWin ()
{
    if (choice[1] == choice[2] && choice[2] == choice[3])
    {
        return 2;
    }
    else if (choice[4] == choice[5] && choice[5] == choice[6])
    {
        return 2;
    }
    else if (choice[7] == choice[8] && choice[8] == choice[9])
    {
        return 2;
    }
    else if (choice[1] == choice[4] && choice[4] == choice[7])
    {
        return 2;
    }
    else if (choice[2] == choice[5] && choice[5] == choice[8])
    {
        return 2;
    }
    else if (choice[3] == choice[6] && choice[6] == choice[9])
    {
        return 2;
    }
    else if (choice[1] == choice[5] && choice[5] == choice[9])
    {
        return 2;
    }
    else if (choice[3] == choice[5] && choice[5] == choice[7])
    {
        return 2;
    }
    else if (choice[1] != '1' && choice[2] != '2' && choice[3] != '3' && choice[4] != '4' && choice[5] != '5' && choice[6] != '6' && choice[7] != '7' && choice[8] != '8' && choice[9] != '9')
        
        return 0;
    else
    {
        return 1;
    }
}



void createBoard ()
{
    cout << "Player 1 is X and Player 2 is O" << endl << endl;
    cout << "   |   |   " << endl;
    cout << " " << choice[1] << " | " << choice[2] << " | " << choice[3] << endl;
    cout << "___|___|___" << endl;
    cout << "   |   |   " << endl;
    cout << " " << choice[4] << " | " << choice[5] << " | " << choice[6] << endl;
    cout << "___|___|___" << endl;
    cout << "   |   |   " << endl;
    cout << " " << choice[7] << " | " << choice[8] << " | " << choice[9] << endl;
    cout << "   |   |   " << endl;
}
