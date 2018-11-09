package People;

import Rooms.MainRoom;

public class Chaser extends Characters
{
    private String firstName, type;
    private int xLoc, yLoc;
    public Chaser (String firstName, int xLoc, int yLoc, String type)
    {
        super(firstName, xLoc,yLoc, type);
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.firstName = firstName;
        this.type = type;
    }

    public String getAction(Chaser x, MainRoom[][] y, Person player)
    {
        String turkeyAction;
        int chance = 0;
        chance = (int) (Math.floor(Math.random() * 4))+1;
        System.out.println(chance);
        if (chance == 1) {
            if (validMove("n", x,y)) {
                player.setyLoc(yLoc++);
                turkeyAction = "north";
            } else {
                turkeyAction = "no where";
            }
        } else if (chance == 2) {
            if (validMove("e", x, y)) {

                player.setxLoc(xLoc++);
                turkeyAction = "east";


            } else {
                turkeyAction = "no where";

            }
        } else if (chance == 3) {
            if (validMove("s", x, y)) {

                player.setyLoc(yLoc--);
                turkeyAction = "south";
            } else {
                turkeyAction = "no where";

            }
        } else {
            if (validMove("w", x, y)) {
                player.setxLoc(xLoc--);
                turkeyAction = "west";
            } else {
                turkeyAction = "no where";

            }
        }
        return turkeyAction;
    }
    public static boolean validMove(String move, Characters p, MainRoom[][] building) {

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