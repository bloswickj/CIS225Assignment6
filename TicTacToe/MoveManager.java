/**
 * A class for controlling the moves (board).
 * 
 * @author John Bloswick 
 * @version 1.0
 */

import java.util.Scanner;

public class MoveManager
{
    private Move[][] moves;
    
    public MoveManager()
    {
        moves = new Move[][]{{Move.EMPTY, Move.EMPTY, Move.EMPTY},
                             {Move.EMPTY, Move.EMPTY, Move.EMPTY},
                             {Move.EMPTY, Move.EMPTY, Move.EMPTY}};
    }
    
    public void printMoves()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.print("\n");
            for(int j = 0; j < 3; j++)
            {
                System.out.print("|");               
                if(moves[i][j] == Move.EMPTY)
                {
                    System.out.print(" ");
                }
                else if(moves[i][j] == Move.X)
                {
                    System.out.print("X");
                }
                else if(moves[i][j] == Move.O)
                {
                    System.out.print("O");
                }
                if(j == 2)
                {
                    System.out.print("|");
                }
            }
        }
        System.out.print("\n");
    }
    
    public void makeMove(int currentPlayer)
    {
        int slot = 0;
        boolean validMove = false;
        Move moveType = Move.EMPTY;
        Scanner scan = new Scanner(System.in);
                 
        if(currentPlayer == 1)
        {
            moveType = Move.X;
        }
        else if(currentPlayer == 2)
        {
            moveType = Move.O;
        }
        
        while(!validMove)
        {
            while(slot < 1 || slot > 9)
            {
                System.out.println("\nPlayer " + currentPlayer + " move: ");
                slot = scan.nextInt();
                if(slot < 1 || slot > 9)
                {
                    System.out.println("\nThat is not a valid move!");
                }
            }        
            
            switch(slot)
            {
                case 1:
                    if(moves[0][0] == Move.EMPTY)
                    {
                        moves[0][0] = moveType;
                        validMove = true;
                    }
                break;
                
                case 2:
                    if(moves[0][1] == Move.EMPTY)
                    {
                        moves[0][1] = moveType;
                        validMove = true;
                    }
                break;
                
                case 3:
                    if(moves[0][2] == Move.EMPTY)
                    {
                        moves[0][2] = moveType;
                        validMove = true;
                    }
                        
                break;
                
                case 4:
                    if(moves[1][0] == Move.EMPTY)
                    {
                        moves[1][0] = moveType;
                        validMove = true;
                    }
                break;
                
                case 5:
                    if(moves[1][1] == Move.EMPTY)
                    {
                        moves[1][1] = moveType;
                        validMove = true;
                    }
                break;
                
                case 6:
                    if(moves[1][2] == Move.EMPTY)
                    {
                        moves[1][2] = moveType;
                        validMove = true;
                    }
                break;
                
                case 7:
                    if(moves[2][0] == Move.EMPTY)
                    {
                        moves[2][0] = moveType;
                        validMove = true;
                    }
                break;
                
                case 8:
                    if(moves[2][1] == Move.EMPTY)
                    {
                        moves[2][1] = moveType;
                        validMove = true;
                    }
                break;
                
                case 9:
                    if(moves[2][2] == Move.EMPTY)
                    {
                        moves[2][2] = moveType;
                        validMove = true;
                    }
                break;
            }
            if(validMove == false)
            {
                System.out.println("\nThat is not a valid move!");
                slot = 0;
            }
        }
    }
    
    public int checkForWinner()
    {
        int winner = 0;
        boolean emptySlot = false;
        for(int i = 0; i < 3; i++)
        {
            if(moves[i][0] == moves[i][1] && moves[i][0] == moves[i][2])
            {
                if(moves[i][0] == Move.X)
                {
                    winner = 1;
                    break;
                }
                else if(moves[i][0] == Move.O)
                {
                    winner = 2;
                    break;
                }
            }
            else if(moves[0][i] == moves[1][i] && moves[0][i] == moves[2][i])
            {
                if(moves[0][i] == Move.X)
                {
                    winner = 1;
                    break;
                }
                else if(moves[0][i] == Move.O)
                {
                    winner = 2;
                    break;
                }
            }
        }
        if(moves[0][0] == moves [1][1] && moves[0][0] == moves[2][2])
        {
                if(moves[0][0] == Move.X)
                {
                    winner = 1;
                }
                else if(moves[0][0] == Move.O)
                {
                    winner = 2;
                }            
        }
        else if(moves[0][2] == moves[1][1] && moves[0][2] == moves[2][0])
        {
                if(moves[0][2] == Move.X)
                {
                    winner = 1;
                }
                else if(moves[0][2] == Move.O)
                {
                    winner = 2;
                }        
        }
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(moves[i][j] == Move.EMPTY)
                {
                    emptySlot = true;
                }
            }
        }
        if(!emptySlot)
        {
            winner = 3;
        }
        return winner;
    }
    
    public void resetMoves()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                moves[i][j] = Move.EMPTY;
            }
        }
    }
}
