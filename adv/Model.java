// Model class is designed to store data
// We can set data in model and can get data in model
// CPU GPU Power supply Ram SSD Motherboard Case Cooler
// import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Model {
    private String data;
    private Map<String, List<String>> database;
    private Map<String, Integer> chosen;
    // private List<String> components;
    private String components[];
    public Model(){
        this.database = new HashMap<String, List<String> >();
        this.chosen = new HashMap<String, Integer>();
        this.components = new String[] {"CPU", "GPU", "Power supply", "Ram", "SSD","Motherboard" ,"Case", "Cooler" };
        // System.out.println(Arrays.toString(this.components));
        for(int i = 0; i < this.components.length; i++){
            this.chosen.put(this.components[i], -1);
        }
        Get_CPUs();
    }
    public void Get_CPUs(){
        BufferedReader reader;
        List<String> CPUs = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader("./CPU.txt"));
            String line = reader.readLine();
            while(line  != null){
                CPUs.add(line);
                line = reader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        this.database.put("CPU", CPUs);
        
    }
    public String getData(){
        return this.data;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getCPU(){
        return this.database.get("CPU").get(0);
    }
    public String getStatus(){
        String Status = "\n******Status******\n";
        for(int i = 0; i < this.components.length; i++){
            Status += this.components[i];
            int rank = this.chosen.get(this.components[i]);
            if(rank < 0){
                Status += ": not chosen\n";
            }
        }
        return Status;
    }
}
