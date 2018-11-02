package Rooms;

import People.Person;
public class MainRoom {

        Person[] occupant = new Person[2];

        int xLoc,yLoc;

        public MainRoom(int x, int y)
        {
            xLoc = x;
            yLoc = y;
        }
        public Person[] getOccupants()
        {
            return occupant;
        }
        /**
         * Method controls the results when a person enters this room.
         * @param x the Person entering
         */
        public void enterRoom(Person x)
        {
            System.out.println("You enter a plain old room");
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
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


    }

