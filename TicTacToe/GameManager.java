/**
 * A class that handles the flow of the game.
 * 
 * @author John Bloswick 
 * @version 1.0
 */

import java.util.Scanner;

public class GameManager
{
    private int currentPlayer, winningPlayer;
    
    public GameManager()
    {
        currentPlayer = 1;
        winningPlayer = 0;
    }
    
    public void gameLoop()
    {
        boolean gameOver = false;
        MoveManager moveManager = new MoveManager();
        currentPlayer = 1;
        winningPlayer = 0;
        
        while(!gameOver)
        {    
            moveManager.makeMove(currentPlayer);
            moveManager.printMoves();
            winningPlayer = moveManager.checkForWinner();
            if(winningPlayer != 0)
            {
                printWinningPlayer();
                if(!checkPlayAgain())
                {
                    gameOver = true;
                }
                else
                {
                    moveManager.resetMoves();
                }
            }
            swapCurrentPlayer();
        }
        printGoodbye();
    }

    private void swapCurrentPlayer()
    {
        if(currentPlayer == 1)
        {
            currentPlayer = 2;
        }
        else
        {
            currentPlayer = 1;
        }
    }
    
    private void printWinningPlayer()
    {
        switch (winningPlayer)
        {
            case 1:
                System.out.println("\nPlayer 1 is the winner!");
                break;
            case 2:
                System.out.println("\nPlayer 2 is the winner!");
                break;
            case 3:
                System.out.println("\nIt's a cats game!");
                break;
        }
    }
    
    private boolean checkPlayAgain()
    {
        boolean validResponse = false;
        String userInput = "";
        Scanner scan = new Scanner(System.in);
        
        while(!validResponse)
        {
            System.out.println("\nWould you like to play again? (yes or no): ");
            userInput = scan.next().toUpperCase();
            if(userInput.equals("YES") || userInput.equals("NO"))
            {
                validResponse = true;
            }
        }
        if(userInput.equals("YES"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void printGoodbye()
    {
        System.out.println("\n\tThanks for playing! Goodbye.");
    }
}
