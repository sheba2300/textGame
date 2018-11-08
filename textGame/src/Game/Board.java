package Game;
import Rooms.MainRoom;
import Rooms.WinningRoom;
import Rooms.ChaserRoom;
import Rooms.Rooms;
public class Board extends java.lang.Object
{
    private Rooms[][] board;

    public Board(Rooms[][] x) {
        board = x;
    }

    public Board(int height, int width)
    {
        this.board = new MainRoom[width][height];
    }

    public void addRoom(int row, int column, MainRoom x) {
        board[row][column] = x;
    }

    }
    @Override
    public String toString()
{
    String boardDisplay = "";
    for(int x = 0; x < this.board.length; x++)
    {
        for(int i = 0; i <this.board[x].length; x++)
        {
            if(board[x][i].getClass() == ChaserRoom)
                boardDisplay += "⎦˚~˚⎣";
            else if(board[x][i].getClass() == MainRoom)
                boardDisplay += "⊙>";
            else {
                boardDisplay += "| |";
            }

    }
        boardDisplay += "\n";

    }
    return boardDisplay;
}
    public void edit(Rooms replace, int row, int column)
    {
        this.board[row][column] = replace;
    }

    public void fill (Rooms filler)
    {
        for(int x = 0; x < this.board.length;x++)
        {
            for( int i =0; i<this.board[x].length;x++)
            {
                this.board[x][i] = filler;
            }
        }
    }
}