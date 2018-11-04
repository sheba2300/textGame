package People;

public class Chaser extends Characters {
    private String firstName;
    private int xLoc;
    private int yLoc;
    public People(String firstName, int xLoc, int yLoc)
    {
        super("People");
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.firstName = firstName;
    }
}