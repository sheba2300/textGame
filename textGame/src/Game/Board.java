// Sheba Sow
package Game;
import Rooms.MainRoom;
import Rooms.Rooms;
public class Board extends java.lang.Object
{

    private Rooms[][] finalBoard;
    private String[][] pattern;
    public Board(int width, int height)
    {
        this.finalBoard = new Rooms[height][width];
        for (int x = 0; x<finalBoard.length; x++)
        {
            for (int y = 0; y <finalBoard[x].length; y++)
            {
                finalBoard[x][y] = new MainRoom(x,y);

            }
        }

    }
    public Rooms getRoom( int row, int col)
    {
        return finalBoard[row][col];
    }
    public void setRoom(Rooms x, int row, int col)
    {
        finalBoard[row][col] = x;
    }
    public Board(MainRoom[][] x)
    {
        finalBoard = x;
    }



    @Override
    public String toString()
{

    String finalBoardDisplay = "";
    for(int x = 0; x < finalBoard.length; x++)
    {
        for(int i = 0; i <finalBoard[x].length; i++)
        {
            finalBoardDisplay += finalBoard[x][i].toString();
        }
        finalBoardDisplay += "\n";
    }
    return finalBoardDisplay;
}


    public void edit(String replace, int row, int column)
    {
        pattern[row][column] = replace;
    }

    public void fill (String filler)
    {
        for(int x = 0; x < pattern.length;x++)
         {
            for( int i =0; i<pattern[x].length;i++)
             {
                 pattern[x][i] = filler;
             }
        }
    }
}