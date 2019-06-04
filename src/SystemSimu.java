import java.util.ArrayList;
import java.util.List;

public class System {
    private List<App> totalApps;

    public System(){

    }

    public System(int numberOfApps){
        createApps(numberOfApps);
    }

    private void createApps(int numberOfApps) {
        List<App> apps = new ArrayList<>();
        for(int i = 0; i < numberOfApps; i++){
            apps.add(new App(10.0 + i, 0));
        }
        this.totalApps = apps;
    }

    public List<App> getApps(){
        return(this.totalApps);
    }

    public double getTotalRigidity(){
        double total = 0.0;
        for(int i = 0; i < totalApps.size(); i++){
            total += totalApps.get(i).getRigidity();
        }
        return total;
    }
}
