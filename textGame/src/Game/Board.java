package Game;
import Rooms.MainRoom;
import Rooms.Rooms;
public class Board extends java.lang.Object
{
    private Rooms[][] boardOne;
    private Rooms[][] boardTwo;
    private Rooms[][] finalBoard;


    public Board(Rooms[][] main, Rooms[][] chase)
    {
        boardOne = main;
        boardTwo = chase;
    }

  
    public void addRoom(int row, int column, MainRoom x)
    {
       finalBoard[row][column] = x;
    }


    @Override
    public String toString()
{
    String finalBoardDisplay = "";
    for(int x = 0; x < finalBoard.length; x++)
    {
        for(int i = 0; i <finalBoard[x].length; x++)
        {
            if(boardOne[x][i].getOccupants()[0] != null ||boardOne[x][i].getOccupants()[1] != null)
                finalBoardDisplay += "⎦˚~˚⎣";
            else if(boardTwo[x][i].getOccupants()[0] != null ||boardTwo[x][i].getOccupants()[1] != null)
                finalBoardDisplay += "⊙>";
            else {
                finalBoardDisplay += "| |";
            }

    }
        finalBoardDisplay += "\n";

    }
    return finalBoardDisplay;
}
    public void edit(Rooms replace, int row, int column)
    {
        this.finalBoard[row][column] = replace;
    }

    public void fill (Rooms filler)
    {
        for(int x = 0; x < finalBoard.length;x++)
        {
            for( int i =0; i<this.finalBoard[x].length;x++)
            {
                this.finalBoard[x][i] = filler;
            }
        }
    }
}