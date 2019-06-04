import java.util.ArrayList;
import java.util.List;

public class App {

    private double rigidity;

    public App(){
        setRigidity(50.0);
    }

    public App(double rigidity){
        setRigidity(rigidity);
    }

    public double getRigidity(){
        return(this.rigidity);
    }

    public void setRigidity(double rigidity){
        this.rigidity = rigidity;
    }

    public static void main(String[] args) {
        List<App> apps = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            apps.add(new App(60.0 + i));
        }

        for(int i = 0; i < apps.size(); i++){
            System.out.println(apps.get(i).getRigidity());
        }
    }
}
