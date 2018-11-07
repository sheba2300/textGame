package Rooms;
import Game.Runner;
import People.Chaser;
import People.Characters;

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
            if (chance == 1) {
                yLoc = yLoc +1;
                turkeyAction = "north";
            } else if (chance == 2)
            {
                xLoc = xLoc +1;
                turkeyAction = "east";

            }
            else if (chance == 3)
            {
                yLoc = yLoc -1;
                turkeyAction = "south";

            }
            else {
                xLoc = xLoc -1;
                turkeyAction = "west";

            }
            for(int i = 0; i<y[xLoc][yLoc].getOccupants().length;i++)
            {
                if(occupant[i] == null && occupant[i] == x)
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
            for(int i =0; i<y[xLoc][yLoc].getOccupants().length; i++)
            {
                if(occupant[i] == x)
                    occupant[i] = null;
            }

    }
}
