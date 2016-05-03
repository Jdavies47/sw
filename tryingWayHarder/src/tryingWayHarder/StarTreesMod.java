package tryingWayHarder;

public class StarTreesMod extends StarTrees {


    public StarTreesMod(int[] xTrees, int[] yTrees, int[] scaleTrees, int numberOfBaubles, int numberOfVertices,
                        int userSteps, int colourOfBaubles, int colourOfStar, int starThickness, String message) {
        super(xTrees, yTrees, scaleTrees, numberOfBaubles, numberOfVertices, userSteps);
        this.colourOfBaubles = colourOfBaubles;
        this.colourOfStar = colourOfStar;
        this.starThickness = starThickness;
        this.message = message;
    }


}
