// Sheba Sow
package Game;
import java.util.Scanner;

import People.Person;
import People.Chaser;
import Rooms.MainRoom;
import Rooms.Rooms;
import People.Characters;
import Rooms.WinningRoom;
public class Runner {


        private static boolean gameOn = true;

        public static void main(String[] args)
        {
            String playerName = "";
            String turkeyName = "";
            String action;
            MainRoom[][] building = new MainRoom[5][5];

            //Fill the building with normal rooms
            for (int x = 0; x<building.length; x++)
            {
                for (int y = 0; y < building[x].length; y++)
                {
                    building[x][y] = new MainRoom(x,y);

                }
            }



            //Create a random winning room.
            building[4][3] = new WinningRoom(4,3);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your name");
            playerName = input.nextLine();
            System.out.println("Enter the name of the turkey that will be chasing you.");
            turkeyName = input.nextLine();
            System.out.println("Get out of the forest before " + turkeyName + " the turkey finds you. The exit is located at 4,4 :(✿◠‿◠)");

            //Setup player 1 and the input scanner
            Person player = new Person(playerName, 0,0,"person");
            Chaser turkey = new Chaser(turkeyName,2,2,"chaser");

            building[0][0].enterRoom(player);
            building[2][2].enterRoom(turkey);
            Board map = new Board(building);
            map.fill("| |");
            System.out.println(map.toString());
            Scanner in = new Scanner(System.in);
            while(gameOn)
            {
                System.out.println("Where would you like to move? (Choose N, S, E, W)");
                String move = in.nextLine();
                if(validMove(move, player, building))
                {
                    System.out.println("Your are located at " + player.getxLoc() + ", " + player.getyLoc());
                    building[turkey.getxLoc()][turkey.getyLoc()].leaveRoom(turkey);
                    action = turkey.getAction(turkey,building);
                    if(validMove(action,turkey, building))
                    {
                        if(action.equals("n"))
                        System.out.println(turkey.getFirstName()+ " moved 1 space north");
                        else if(action.equals("s"))
                            System.out.println(turkey.getFirstName()+ " moved 1 space south");
                        else if(action.equals("e"))
                            System.out.println(turkey.getFirstName()+ " moved 1 space east");
                        else
                            System.out.println(turkey.getFirstName()+ " moved 1 space west");
                    }
                    else
                    {
                        System.out.println("the turkey did not move");
                    }

                    System.out.println(turkey.getFirstName() + " is located at " +turkey.getxLoc() +","+turkey.getyLoc());
                    building[turkey.getxLoc()][turkey.getyLoc()].enterRoom(turkey);

                }
                else {
                    System.out.println("Please choose a valid move.");
                }

                if (building[player.getxLoc()][player.getyLoc()].found(building[player.getxLoc()][player.getyLoc()].getOccupants()))
                   gameOff();
                System.out.println(map.toString());
            }
            in.close();

        }

        /**
         * Checks that the movement chosen is within the valid game map.
         * @param move the move chosen
         * @param p person moving
         * @param building the 2D array of rooms
         * @return
         */
            public static boolean validMove(String move, Characters p, Rooms[][] building) {
            move = move.toLowerCase().trim();
            switch (move) {
                case "n":
                    if (p.getxLoc() > 0) {
                        building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        building[p.getxLoc() - 1][p.getyLoc()].enterRoom(p);
                        return true;
                    } else {
                        return false;
                    }
                case "e":
                    if (p.getyLoc() < building[p.getyLoc()].length - 1) {
                        building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        building[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                        return true;
                    } else {
                        return false;
                    }

                case "s":
                    if (p.getxLoc() < building.length - 1) {
                        building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        building[p.getxLoc() + 1][p.getyLoc()].enterRoom(p);
                        return true;
                    } else {
                        return false;
                    }

                case "w":
                    if (p.getyLoc() > 0) {
                        building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        building[p.getxLoc()][p.getyLoc() - 1].enterRoom(p);
                        return true;
                    } else {
                        return false;
                    }
                default:
                    break;

            }

return true;

        }
    public static void gameOff()
    {
        gameOn = false;
    }


}
