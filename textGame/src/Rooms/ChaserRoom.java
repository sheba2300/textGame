package Rooms;
import Game.Runner;
import People.Person;

public class ChaserRoom implements Rooms{
    Person[] occupant = new Person[2];
    int chance = 0;
    private int xLoc = 0;
    private int yLoc = 0;
    public ChaserRoom(int x, int y)
        {
            xLoc = x;
            yLoc = y;
        }
    public Person[] getOccupants()
    {
        return occupant;
    }

        public String enterRoom(Person x, Rooms y)
        {
            chance = (int) Math.random() * 4 + 1;
            if (chance == 1) {
                xLoc = xLoc +1;
            } else if (chance == 2)
            {

            }
            else if (chance == 3)
            {

            }
            else {

            }
            for(int i = 0; i<y[xLoc][yLoc].occupant.length;i++)
            {
                if(occupant[i] == null && occupant[i] == x)
                {
                    occupant[i] = x;
                    x.setxLoc(this.xLoc);
                    x.setyLoc(this.yLoc);

                }
            }
        }
        public String leaveRoom(Person x, Rooms y)
        {
            for(int i =0; i<y[xLoc][yLoc].getOccupants().length; i++)
            {
                if(occupant[i] == x)
                    occupant[i] = null;
            }

    }
}
