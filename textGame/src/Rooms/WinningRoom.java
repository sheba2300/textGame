package Rooms;
import Game.Runner;
import People.Person;

public class WinningRoom extends MainRoom
{
    private int xLoc,yLoc;
    public WinningRoom(int x, int y) {
        super(x,y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        System.out.println("You won, Congrats!");
    }


}