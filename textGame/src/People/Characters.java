package People;
public class Characters {
    private String firstName;
    private int xLoc, yLoc;


    public Characters (String firstName,int xPos, int yPos)
    {
        this.firstName = firstName;
        xLoc = xPos;
        yLoc = yPos;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xPos) {
        xLoc = xPos;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yPos) {
        yLoc = yPos;
    }
    public String getFirstName() {
        return firstName;
    }
}


