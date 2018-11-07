package Rooms;

import People.Person;
import People.Characters;

public class MainRoom implements Rooms{
    Person[] occupant = new Person[2];

        int xLoc,yLoc;

        public MainRoom(int x, int y)
        {
            xLoc = x;
            yLoc = y;
        }
        public Characters[] getOccupants()
        {
            return occupant;
        }
        /**
         * Method controls the results when a person enters this room.
         * @param x the Person entering
         */
        public String enterRoom(Person x)
        {
            System.out.println("Now where did the turkey go....");
            for(int i = 0; i<occupant.length;i++)
            {
                if(occupant[i] == null || occupant[i] == x)
                {
                    x.setxLoc(this.xLoc);
                    x.setyLoc(this.yLoc);
                    occupant[i] = x;
                    return "";
                }
            }
            return "";
        }

        /**
         * Removes the player from the room.
         * @param x
         */
        public void leaveRoom(Person x)
        {
            for(int i =0; i< occupant.length; i++)
            {
                if(occupant[i] == x)
                occupant[i] = null;
            }
        }
        public static boolean found(Characters[] occupant)
        {
            if(occupant[0] != null && occupant[1] != null)
                return true;
            return false;
        }


    }

