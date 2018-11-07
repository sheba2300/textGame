package Game;
import java.util.Scanner;
import People.Characters;
import People.Person;
import People.Chaser;
import Rooms.MainRoom;
import Rooms.WinningRoom;
import Rooms.ChaserRoom;
public class Runner {


        private static boolean gameOn = true;

        public void main(String[] args)
        {
            String playerName = "";
            String turkeyName = "";
            MainRoom[][] building = new MainRoom[5][5];
            ChaserRoom[][] turkeyRoom = new ChaserRoom[5][5];

            //Fill the building with normal rooms
            for (int x = 0; x<building.length; x++)
            {
                for (int y = 0; y < building[x].length; y++)
                {
                    building[x][y] = new MainRoom(x,y);
                }
            }

            //Create a random winning room.
            building[5][5] = new WinningRoom(5,5);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your name");
            playerName = input.nextLine();
            System.out.println("Enter the name of the turkey that will be chasing you.");
            turkeyName = input.nextLine();
            //Setup player 1 and the input scanner
            Person player = new Person(playerName, 0,0);
            Chaser turkey = new Chaser(turkeyName,0,4);

            building[0][0].enterRoom(player);
            Scanner in = new Scanner(System.in);
            while(gameOn)
            {
                System.out.println("Where would you like to move? (Choose N, S, E, W)");
                String move = in.nextLine();
                if(validMove(move, player, building))
                {
                    System.out.println("Your coordinates: row = " + player.getxLoc() + " col = " + player.getyLoc());
                    System.out.println(turkeyName + " moved 1 space " +turkeyRoom[turkey.getxLoc()][turkey.getyLoc()].enterRoom(turkey, turkeyRoom));
                }
                else {
                    System.out.println("Please choose a valid move.");
                }

                if (building[player.getxLoc()][player.getyLoc()].found(building[player.getxLoc()][player.getyLoc()].getOccupants()))
                    gameOn = false;

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
        public static boolean validMove(String move, Person p, MainRoom[][] building) {
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

}
