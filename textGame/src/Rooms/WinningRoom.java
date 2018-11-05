package Rooms;
import Game.Runner;
import People.Person;

public class WinningRoom
{
    private int xLoc,yLoc;
    public WinningRoom(int x, int y) {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */

    public void enterRoom(Person x) {
        System.out.println("You won, Congrats!");
        Runner.gameOff();
    }


}