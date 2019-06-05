import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    private double rigidity;
    private List<App> apps;

    public App(){
        setRigidity(50.0);
    }

    public App(double rigidity, int number){
        setRigidity(rigidity);
        this.apps = new ArrayList<>();
    }

    public double getRigidity(){
        return(this.rigidity);
    }

    public void setRigidity(double rigidity){
        this.rigidity = rigidity;
    }

    public void setApp(App app){
        this.apps.add(app);
    }

    public List<App> getApps(){
        return(this.apps);
    }

    public List<Double> getRigidityOfLinkedApps(){
        List<Double> d = new ArrayList<>();
        //System.out.println(getRigidity());
        d.add(getRigidity());
        for(int i = 0; i < getApps().size(); i++){
            d.add(getApps().get(i).getRigidity());
        }
        return (d);
    }

    public static List<Double> makeGeneration(int rigidity){
        SystemSimu systemSimu = new SystemSimu(5, rigidity);
        App app = systemSimu.getApps().get(0);
        for(int i = 1; i < systemSimu.getApps().size(); i++) {
            app.setApp(systemSimu.getApps().get(i));
        }
        List<Double> d = app.getRigidityOfLinkedApps();
        d.add(systemSimu.getTotalRigidity());
        return(d);
    }

    public static void main(String[] args) {
        DisplayInterface display = new DisplayImageStrategy();//DisplayConsoleStrategy();
        for(int i = 0; i < 10; i++){
            List<Double> d = makeGeneration(i*5);
            display.printGenerationFull(d, i);
        }
        display.show(10);
    }
}
