package Game;
import Rooms.MainRoom;
import Rooms.Rooms;
public class Board extends java.lang.Object
{

    private Rooms[][] finalBoard;
    private String[][] pattern = new String[5][5];

    public Board(MainRoom[][] x, int height, int width)
    {
        finalBoard = x;
        finalBoard = new Rooms[width][height];
    }



    @Override
    public String toString()
{
    System.out.println(finalBoard[0][0].getOccupants()[0].getxLoc());
    String finalBoardDisplay = "";
//    for(int x = 0; x < finalBoard.length; x++)
//    {
//        for(int i = 0; i <finalBoard[x].length; i++)
//        {
//            if(finalBoard[x][i].getOccupants()[0].getType().equals("person") || finalBoard[x][i].getOccupants()[1].getType().equals("person"))
//                finalBoardDisplay += "⎦˚~˚⎣";
//            else if(finalBoard[x][i].getOccupants()[0].getType().equals("chaser") || finalBoard[x][i].getOccupants()[1].getType().equals("chaser"))
//                finalBoardDisplay += "⊙>";
//            else {
//                finalBoardDisplay += "| |";
//            }
//
//    }
//        finalBoardDisplay += "\n";


    return "oof";
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