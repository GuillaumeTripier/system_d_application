import java.util.ArrayList;
import java.util.List;

public class Legend {
    private int count;
    private List<String> colors;

    public Legend(){

    }

    public Legend(int count){
        this.count = count;
        setColors();
    }

    private void setColors(){
        List<String> colors = new ArrayList<>();
        for(int i = 0; i < this.count; i++){
            colors.add("00f" + System.out.printf("%.2f", (int) Long.parseLong(Integer.toHexString(i), 16) + "0"));
        }
        colors = colors;
    }

    public String getColor(int position){
        return(this.colors.get(position));
    }
}
