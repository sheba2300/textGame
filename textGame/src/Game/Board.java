package Game;
import Rooms.MainRoom;
import Rooms.WinningRoom;
import Rooms.ChaserRoom;
public class Board {
    private MainRoom[][] board;

    public Board(MainRoom[][] x) {
        board = x;
    }

    public Board(int height, int width) {
        this.board = new MainRoom[width][height];
    }

    public void addRoom(int row, int column, MainRoom x) {
        board[row][column] = x;
    }

    public boolean found() {
        for (int x = 0; x < board.length; x++) {
            for (int i = 0; i < board[x].length; i++) {
                if (board[x][i].getOccupants()[0] != null && board[x][i].getOccupants()[0] != null)
                    return true;
                return false;
            }
        }
        return false;
    }
}