import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DisplayMoyennePlotStrategy implements DisplayInterface {
    private Plot plot;
    private List<List<Double>> points;

    public DisplayMoyennePlotStrategy(){
        this.plot = Plot.plot(Plot.plotOpts().
                title("Hello World").
                legend(Plot.LegendFormat.BOTTOM)).
                xAxis("x", Plot.axisOpts().
                        range(0, 9)).
                yAxis("y", Plot.axisOpts().
                        range(0, 60));
        this.points = new ArrayList<>();
    };

    @Override
    public void printGenerationFull(List<Double> d, int number) {
        List<Double> point = new ArrayList<>();
        point.add((double)number);
        point.add(d.get(d.size()-1));
        this.points.add(point);
    }

    @Override
    public void show(int generationCount) {
        for(int j = 0; j < generationCount; j++) {
            List<Double> x = new ArrayList<>();
            List<Double> y = new ArrayList<>();
            //for (int i = j; i < this.points.size(); i += generationCount) {
                x.add(this.points.get(j).get(0));
                y.add(this.points.get(j).get(1));
            //}
            this.plot.series("Génération " + j, Plot.data().
                            xy(x, y),
                    Plot.seriesOpts().
                            marker(Plot.Marker.CIRCLE).
                            markerColor(Color.GREEN).
                            color(Color.BLACK));
        }
        try {
            plot.save("sample_minimal3", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
