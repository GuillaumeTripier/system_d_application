import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DisplayImageStrategy implements DisplayInterface {
    private Plot plot;
    private List<List<Double>> points;

    public DisplayImageStrategy(){
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
        //Legend l = new Legend(d.size()-1);
        for(int i = 0; i < d.size()-1; i++) {
            List<Double> point = new ArrayList<>();
            point.add((double)number);
            point.add(d.get(i));
            this.points.add(point);
            //this.plot//.setPoint(d.get(i)).setColor(l.getColor(i));
        }


    }

    @Override
    public void show(int generationCount) {
        for(int j = 0; j < generationCount; j++) {
            List<Double> x = new ArrayList<>();
            List<Double> y = new ArrayList<>();
            for (int i = j; i < this.points.size(); i += generationCount) {
                x.add(this.points.get(i).get(0));
                y.add(this.points.get(i).get(1));
            }
            this.plot.series("Génération " + j, Plot.data().
                            xy(x, y),
                    Plot.seriesOpts().
                            marker(Plot.Marker.CIRCLE).
                                    markerColor(Color.GREEN).
                            color(Color.BLACK));
        }
        try {
            plot.save("sample_minimal2", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
