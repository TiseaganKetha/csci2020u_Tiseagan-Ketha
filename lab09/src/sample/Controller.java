package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Controller {
    
    @FXML Canvas canvas;
    GraphicsContext gc;
    double maximum = 0.0;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        ArrayList<Double> arrayList_apple = downloadStockPrices("AAPL");
        ArrayList<Double> arrayList_google = downloadStockPrices("GOOG");
        drawLinePlot(arrayList_apple, arrayList_google);
    }

    public ArrayList<Double> downloadStockPrices(String stockTicker) {
        ArrayList<Double> costs = new ArrayList();
        String startingURL = "https://query1.finance.yahoo.com/v7/finance/download/ticker?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true";
        try {
            InputStream input_file = new URL(startingURL.replace("ticker", stockTicker)).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input_file, StandardCharsets.UTF_8));
            String l;
            boolean aL = false;
            double value;

            while ((l = reader.readLine()) != null) {
                if (aL != false) {
                    value = Double.parseDouble(l.split(",")[4]);
                    costs.add(value);

                    if (value > maximum) {
                        maximum = value;
                    }
                }
                aL = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return costs;
    }

    public void drawLinePlot(ArrayList<Double> fTP, ArrayList<Double> sTP) {
        double height = canvas.getHeight() - 50;
        double width = canvas.getWidth() - 50;

        gc.setStroke(Color.BLACK);
        gc.strokeLine(50, 50, 50, height);
        gc.strokeLine(50, height, width, height);

        gc.setStroke(Color.BLUE);
        plotLine(fTP);
        gc.setStroke(Color.RED);
        plotLine(sTP);
    }

    public void plotLine(ArrayList<Double> tP) {
        double first_x = 0.0;
        double sizeArray = tP.size() - 1;
        double height = canvas.getHeight() - 100;
        double width = canvas.getWidth() - 100;

        for (int i = 0; i < sizeArray; i++) {

            double first_Price = (tP.get(i) / maximum) * height;
            double second_Price = (tP.get(i + 1) / maximum) * height;

            double first_y = height - first_Price + 50;

            double second_x = first_x + width / tP.size() + 50;
            double second_y = height - second_Price + 50;

            gc.strokeLine(first_x + 50, first_y, second_x, second_y);

            first_x = first_x + width / tP.size();
        }
    }

}
