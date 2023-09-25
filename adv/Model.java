// Model class is designed to store data
// We can set data in model and can get data in model
// CPU GPU Power supply Ram SSD Motherboard Case Cooler
// import java.io.File;

// I refer to https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line to read files in java
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
        this.components = new String[] {"CPU", "GPU", "PowerSupply", "Ram", "Storage","Motherboard" ,"Case", "Cooler" };
        this.clear_chosen();
        // System.out.println(Arrays.toString(this.components));
        // for(int i = 0; i < this.components.length; i++){
        //     this.chosen.put(this.components[i], -1);
        // }
        Get_Data();
    }
    public void Get_Data(){
        String data_add = "./dataset/";
        for(int i = 0; i < this.components.length; i++){
            BufferedReader reader;
            List<String> Tmp = new ArrayList<>();
            String filename = data_add + this.components[i] + ".txt";
            try{
                reader = new BufferedReader(new FileReader(filename));
                String line = reader.readLine();
                while(line  != null){
                    Tmp.add(line);
                    line = reader.readLine();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            this.database.put(this.components[i], Tmp);
        }
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
    public String getComponents(){
        String Components = "";
        for(int i = 0; i < this.components.length; i++){
            Components += i;
            Components += ": ";
            Components += this.components[i];
            Components += "     ";
        }
        return Components;
    }
    public String getStatus(){
        String Status = "\n******hardware list******\n";
        int Cost = 0;
        for(int i = 0; i < this.components.length; i++){
            Status += this.components[i];
            int rank = this.chosen.get(this.components[i]);
            if(rank < 0){
                Status += ": not chosen\n";
            }
            else{
                String[] parts = this.database.get(this.components[i]).get(rank).split("\t");
                Status += ": ";
                Status += parts[0];
                Cost += Integer.parseInt(parts[1]);
                Status += "\n";
            }
        }
        Status += "Total cost :" + Cost +"$\n";
        return Status;
    }
    public String getRecommend(int Type){
        // {"CPU", "GPU", "PowerSupply", "Ram", "Storage","Motherboard" ,"Case", "Cooler" };
        String Status = "\n******Recommend hardware list******\n";
        int Recommend[];
        if(Type == 0){
            Recommend = new int[] {7,4,0,0,2,4,1,3};
        }
        else if(Type == 1){
            Recommend = new int[] {1,3,2,1,0,0,0,0};;
        }
        else{
            Recommend = new int[] {5,3,1,2,2,2,2,2};;
        }
        int Cost = 0;
        for(int i = 0; i < this.components.length; i++){
            Status += this.components[i];
            int rank = Recommend[i];
            if(rank < 0){
                Status += ": not chosen\n";
            }
            else{
                String[] parts = this.database.get(this.components[i]).get(rank).split("\t");
                Status += ": ";
                Status += parts[0];
                Cost += Integer.parseInt(parts[1]);
                Status += "\n";
            }
        }
        Status += "Total cost :" + Cost +"$\n";
        return Status;
    }
    public String getTypes(int ID){
        String Type = this.components[ID];
        String Types = "";
        for (int i = 0; i < this.database.get(Type).size(); i++) {
            Types += i;
            Types += ": ";
            Types += this.database.get(Type).get(i).split("\t")[0];
            Types += "     ";
        }
        return Types;
    }
    public void set_chosen(int ID,int ID_c){
        String Type = this.components[ID];
        this.chosen.put(Type, ID_c);
        return;
    }
    public void clear_chosen(){
        for(int i = 0; i < this.components.length; i++){
            this.chosen.put(this.components[i], -1);
        }
        return;
    }
}
