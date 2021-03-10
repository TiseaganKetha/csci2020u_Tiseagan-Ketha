// Correct package label
package sample;

// Needed imports
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {

    // Variables to set up application and to link to sample.fxml
    @FXML public GraphicsContext gc;
    @FXML private Canvas mCanvas;

    // All sample data code given
    private static double[] avgHousingPricesByYear = {247381.0,264171.4,287715.3,294736.1, 308431.4,322635.9,340253.0,363153.7};
    private static double[] avgCommercialPricesByYear = {1121585.3,1219479.5,1246354.2,1295364.8, 1335932.6,1472362.0,1583521.9,1613246.3};
    private static String[] ageGroups = {"18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = {648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};

    // Function to start and display all functions with their respective graphs
    @FXML public void initialize(){
        gc = mCanvas.getGraphicsContext2D();
        PieGraph(1000,purchasesByAgeGroup,pieColours);
        BarGraph(150,350, avgHousingPricesByYear,avgCommercialPricesByYear);
    }

    // Function used to draw bar graph
    public void BarGraph(int value1, int value2, double[]array1, double []array2){

        // Variables
        double max_value = 0;
        double min_value = 0;
        double space = value1 / array1.length;
        double temp, temp2, temp3;
        double initial_point = 150;

        // This loop uses the average housing prices array to set up and find the needed values for the next step
        for (int i = 0; i < array1.length; i++) {

            // Conditional statements to find the max and min values
            if (i == 0) {
                max_value = array1[i];
                min_value = array1[i];
            }
            else if (array1[i] > max_value) {
                max_value = array1[i];
            }
            else if (array1[i] < min_value) {
                min_value = array1[i];
            }
        }

        // This loop uses the average commercial prices array to set up and find the needed values for the next step
        for (int i = 0; i < array2.length; i++) {

            // Conditional statements to find the max and min values
            if (i == 0) {
                max_value = array2[i];
                min_value = array2[i];
            }
            else if (array2[i] > max_value) {
                max_value = array2[i];
            }
            else if (array2[i] < min_value) {
                min_value = array2[i];
            }
        }

        // Colour for the red bar for the average housing prices
        gc.setFill(Color.RED);

        // This loop is used to fill in with colour and display the correct data
        for (int i= 0; i < array1.length; i++){
            temp = array1[i]/max_value;
            temp2 = temp * value2;
            temp3 = value2 - temp2;
            gc.fillRect(initial_point - 100,temp3 + 20, space,temp2 + 20);
            initial_point += (space * 2.5);
        }

        // Variable used to set the spacing between bars
        initial_point = 150 + space;

        // Colour for the blue bar for the average commercial prices
        gc.setFill(Color.BLUE);

        // This loop is used to fill in with colour and display the correct data
        for(int i = 0; i < array2.length; i++){
            temp = array2[i]/max_value;
            temp2 = temp * value2;
            temp3 = value2 - temp2;
            gc.fillRect(initial_point - 100, temp3 + 20, space,temp2 + 20);
            initial_point += (space * 2.5);
        }
    }

    // Function used to draw pie graph
    public void PieGraph(int val, int[]array, Color[]colors){

        // Variables for pie graph
        double result = 0;
        double initial_val = 0;
        double temp, temp2;

        // Loops to create pie graph specific to given data

        // This loop creates the entire number of arcs need to be displayed
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }

        // This loops creates the actual arcs and gives them size and colour
        for (int i = 0; i < array.length; i++) {
            temp = array[i] / result;
            temp2 = 360 * temp;
            gc.setFill(colors[i]);
            gc.fillArc(val / 2,0,300,300, initial_val,(temp2), ArcType.ROUND);
            initial_val += temp2;
        }
    }
}

