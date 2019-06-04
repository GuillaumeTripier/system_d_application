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

    public void printApps(){
        System.out.println(getRigidity());
        for(int i = 0; i < getApps().size(); i++){
            System.out.println(getApps().get(i).getRigidity());
        }
    }

    public static void main(String[] args) {
        SystemSimu systemSimu = new SystemSimu(5);
        App app = systemSimu.getApps().get(0);
        for(int i = 1; i < systemSimu.getApps().size(); i++) {
            app.setApp(systemSimu.getApps().get(i));
        }
        app.printApps();
        System.out.println("\n" + systemSimu.getTotalRigidity());

        // A Faire : calculer la rigidité totale après n générations (à chaque génération, la rigidité augemente de 5% à chaque génération
    }
}
