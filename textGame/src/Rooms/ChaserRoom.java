package Rooms;
import Game.Runner;
import People.Chaser;
import People.Characters;
import People.Person;

public class ChaserRoom implements Rooms{
    Characters[] occupant = new Characters[2];
    int chance = 0;
    private int xLoc = 0;
    private int yLoc = 0;
    public ChaserRoom(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }
    public Characters[] getOccupants()
    {
        return occupant;
    }

    public String enterRoom(Chaser x, ChaserRoom[][] y)
    {

        String turkeyAction;
        chance = (int) Math.random() * 4 + 1;
        if (chance == 1)
        {if(validMove("n", x, y)) {
            System.out.println("n");
            yLoc = yLoc + 1;
            turkeyAction = "north";
        }
        else
        {
            turkeyAction = "no where";
        }
        }
        else if (chance == 2)
        {if(validMove("e", x, y)) {
            System.out.println("e");

            xLoc = xLoc + 1;
            turkeyAction = "east";
            System.out.println("e");

        }
        else
        {
            turkeyAction = "no where";

        }
        }
        else if (chance == 3)
        {if(validMove("s", x, y)) {
            System.out.println("s");

            yLoc = yLoc - 1;
            turkeyAction = "south";
        }
        else
        {
            turkeyAction = "no where";

        }
        }
        else
            {
                if(validMove("w", x, y)) {
                    System.out.println("w");

                    xLoc = xLoc - 1;
                    turkeyAction = "west";
                }
                else
                {
                    turkeyAction = "no where";

                }
            }
            for(int i = 0; i<y[xLoc][yLoc].getOccupants().length;i++)
            {
                if(occupant[i] == null || occupant[i] == x)
                {
                    occupant[i] = x;
                    x.setxLoc(this.xLoc);
                    x.setyLoc(this.yLoc);
                }
            }
            return turkeyAction;
        }
        public String leaveRoom(Chaser x, Rooms y)
        {
            for(int i =0; i<y.getOccupants().length; i++)
            {
                if(occupant[i] == x)
                    occupant[i] = null;
            }
        return"";
    }
    public static boolean validMove(String move, Chaser p, ChaserRoom[][] building) {

        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0) {
                    return true;
                } else {
                    return false;
                }
            case "e":
                if (p.getyLoc() < building[p.getyLoc()].length - 1) {

                    return true;
                } else {
                    return false;
                }

            case "s":
                if (p.getxLoc() < building.length - 1) {

                    return true;
                } else {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0) {

                    return true;
                } else {
                    return false;
                }
            default:
                break;

        }
        return false;


    }
}
