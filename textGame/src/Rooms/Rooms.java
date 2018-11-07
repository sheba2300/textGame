package Rooms;
import People.Characters;

public interface Rooms {
    String enterRoom();
    String leaveRoom();
    Characters[] getOccupants();
}
