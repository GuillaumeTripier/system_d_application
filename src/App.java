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
        setApps(number);
    }

    public double getRigidity(){
        return(this.rigidity);
    }

    public void setRigidity(double rigidity){
        this.rigidity = rigidity;
    }

    public void setApps(int count){
        List<App> apps = new ArrayList<>();
        for(int i = 0; i < count; i++){
            apps.add(new App(10.0 + i, 0));
        }
        this.apps = apps;
    }

    public List<App> getApps(){
        return(this.apps);
    }

    public void printApps(){
        System.out.println(getRigidity());
        for(int i = 0; i < getApps().size(); i++){
            System.out.println(getApps().get(i).getRigidity());
        }
    }

    public double getTotalRigidity(){
        double total = 0.0;
        for(int i = 0; i < getApps().size(); i++){
            total += getApps().get(i).getRigidity();
        }
        total += getRigidity();
        total /= getApps().size() +1;
        return total;
    }

    public static void main(String[] args) {
        App app = new App(14.0, 4);
        app.printApps();
        System.out.println("\n" + app.getTotalRigidity());
    }
}
