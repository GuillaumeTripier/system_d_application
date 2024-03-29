import java.util.ArrayList;
import java.util.List;

public class SystemSimu {
    private List<App> totalApps;

    public SystemSimu(){

    }

    public SystemSimu(int numberOfApps, int rigiditySupp){
        createApps(numberOfApps, rigiditySupp);
    }

    private void createApps(int numberOfApps, int rigiditySupp) {
        List<App> apps = new ArrayList<>();
        for(int i = 0; i < numberOfApps; i++){
            apps.add(new App(10.0 + i + rigiditySupp, 0));
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
        return total/totalApps.size();
    }
}
