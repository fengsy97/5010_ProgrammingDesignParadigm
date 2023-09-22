// Model class is designed to store data
// We can set data in model and can get data in model

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private String data;
    private Map<String, List<String>> dictionary;
    public Model(){
        // List<MyType> myList = new ArrayList<>();
        this.dictionary = new HashMap<String, List<String> >();
        List<String> CPUs = new ArrayList<>();
        CPUs.add("12400F");
        this.dictionary.put("CPU", CPUs);
    }
    public String getData(){
        return this.data;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getCPU(){
        return this.dictionary.get("CPU").get(0);
    }
}
