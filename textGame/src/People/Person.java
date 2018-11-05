package People;

public  class Person extends Characters{

    private String firstName;
    private int xLoc;
    private int yLoc;
    public Person (String firstName, int xLoc, int yLoc)
    {
        super(firstName, xLoc,yLoc);
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.firstName = firstName;
    }


}
