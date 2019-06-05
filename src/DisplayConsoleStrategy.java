import java.util.List;

public class DisplayConsoleStrategy implements DisplayInterface {

    @Override
    public void printGenerationFull(List<Double> d, int number) {
        for(int i = 0; i < d.size()-1; i++) {
            System.out.println(d.get(i));
        }
        System.out.println("Moyenne = " + d.get(d.size()-1));
    }

    @Override
    public void show(int generationCount) {

    }
}
